package edu.sse.ustc.getlocinfo;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.database.save.SaveToDataBase;
import edu.sse.ustc.database.save.impl.SaveToDataBaseImpl;
import edu.sse.ustc.getlocinfo.operation.BasicData;
import edu.sse.ustc.getlocinfo.operation.BasicInfo;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.operation.PushServiceOperation;
import edu.sse.ustc.getlocinfo.operation.impl.BasicDataImpl;
import edu.sse.ustc.getlocinfo.operation.impl.BasicInfoImpl;
import edu.sse.ustc.getlocinfo.operation.impl.ConnectOperationImpl;
import edu.sse.ustc.getlocinfo.operation.impl.PushServiceOperationImpl;
import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.Tag;

public class RPCServerManager {

	private Logger log = Logger.getLogger(this.getClass());

	private BasicData basicData = null;
	private BasicInfo basicInfo = null;
	private PushServiceOperation pushServiceControl = null;
	private SaveToDataBase stdb = null;

	public RPCServerManager() {
		basicData = new BasicDataImpl();
		basicInfo = new BasicInfoImpl();
		pushServiceControl = new PushServiceOperationImpl();
		stdb = new SaveToDataBaseImpl();
	}

	/**
	 * create connect if connect failed,then this process will wait and try to
	 * connect until success
	 * 
	 * @return
	 */
	public ConnectOperation openConnect() {

		ConnectOperation clientConnect = new ConnectOperationImpl();

		// login
		int flag = clientConnect.connect();

		int cnt = 1;
		int time = 1;

		// System.out.println(flag);
		if (flag == -1) {
			MyLog.error("环境名称有误", this.getClass().getName());
		}

		while (flag == -2) {
			clientConnect = new ConnectOperationImpl();
			flag = clientConnect.connect();

			cnt++;

			// System.out.println(flag + " " +
			// clientConnect.getEnvironmentName());

			if (cnt > 100)
				cnt = 1;

			time = (cnt + 10) / 10;
			try {
				Thread.sleep(1000 * time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				MyLog.error(e.toString(), this.getClass().getName());
			}
		}

		return clientConnect;

	}

	/**
	 * close connect
	 * 
	 * @param clientConnect
	 * @return
	 */
	public boolean closeConnect(ConnectOperation clientConnect) {

		return clientConnect.disConnect();
	}

	/**
	 * get basic map data
	 * 
	 * @param mapIDList
	 * @param clientConnect
	 * @return
	 */
	public List<Map> getBasicMapsData(List<Integer> mapIDList, ConnectOperation clientConnect) {

		if (!clientConnect.ping()) {
			MyLog.info("the connection transfered is USELESS!", this.getClass().getName());
			return null;
		}

		return basicData.getMaps(mapIDList, clientConnect);
	}

	/**
	 * save map list to data base
	 * 
	 * @param mapIDList
	 * @param clientConnect
	 * @return
	 */
	public boolean saveBasicMapsData(List<Integer> mapIDList, ConnectOperation clientConnect) {

		return stdb.saveMapList(this.getBasicMapsData(mapIDList, clientConnect));
	}

	/**
	 * get basic Ap data
	 * 
	 * @param mapID
	 * @param apMac
	 * @param clientConnect
	 * @return
	 */
	public List<AP> getBasicApsData(Integer mapID, List<String> apMac, ConnectOperation clientConnect) {

		if (!clientConnect.ping()) {
			// System.out.println("RPC:::client disconnect");
			MyLog.info("the connection transfered is USELESS!", this.getClass().getName());
			return null;
		}

		return basicData.getAPs(mapID, apMac, clientConnect);
	}

	/**
	 * save ap list to database
	 * 
	 * @param mapID
	 * @param apMac
	 * @param clientConnect
	 * @return
	 */
	public boolean saveBasicApsData(Integer mapID, List<String> apMac, ConnectOperation clientConnect) {

		return stdb.saveAPList(this.getBasicApsData(mapID, apMac, clientConnect));
	}

	/**
	 * get basic tag data information
	 * 
	 * @param clientConnect
	 * @return
	 */
	public List<Tag> getBasicTagData(ConnectOperation clientConnect) {

		if (!clientConnect.ping()) {
			// System.out.println("RPC:::client disconnect");
			MyLog.info("the connection transfered is USELESS!", this.getClass().getName());
			return null;
		}

		return basicData.getAllTag(clientConnect);
	}

	public boolean saveBasicTagData(ConnectOperation clientConnect) {

		return stdb.saveAllTags(this.getBasicTagData(clientConnect));
	}

	/**
	 * get basic info data
	 * 
	 * @param clientConnect
	 * @return
	 */
	public Date getBasicServerTimeInfo(ConnectOperation clientConnect) {
		if (!clientConnect.ping()) {
			// System.out.println("RPC:::client disconnect");
			MyLog.info("the connection transfered is USELESS!", this.getClass().getName());
			return null;
		}
		return basicInfo.getServerTime(clientConnect);
	}

	/**
	 * get environment info
	 * 
	 * @param clientConnect
	 * @return
	 */
	public List<Environment> getBasicEnvironmentsInfo(ConnectOperation clientConnect) {
		if (!clientConnect.ping()) {
			// log.warn("RPC:::client disconnect");
			MyLog.info("the connection transfered is USELESS!", this.getClass().getName());
			return null;
		}
		return basicInfo.getAllEnvironments(clientConnect);
	}

	/**
	 * save all environments info
	 * 
	 * @param clientConnect
	 * @return
	 */
	public boolean saveBasicEnvironmentsInfo(ConnectOperation clientConnect) {

		return stdb.saveAllEnvironments(this.getBasicEnvironmentsInfo(clientConnect));
	}

	/**
	 * turn on socket data transport tunnel
	 * 
	 * @param clientConnect
	 * @return
	 */
	public boolean TurnOnSocketService(ConnectOperation clientConnect) {

		return pushServiceControl.TurnOnPushService(clientConnect);
	}

	/**
	 * turn off socket data transport tunnel
	 * 
	 * @param clientConnect
	 * @return
	 */
	public boolean TurnOffSocketService(ConnectOperation clientConnect) {

		return pushServiceControl.TurnOffPushService(clientConnect);
	}

}
