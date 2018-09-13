package edu.sse.ustc.getlocinfo.operation.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.contract.InvalidOperation;
import edu.sse.ustc.getlocinfo.operation.BasicData;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.services.ClassTranslator;
import edu.sse.ustc.getlocinfo.services.impl.ClassTranslatorImpl;
import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.Tag;

public class BasicDataImpl implements BasicData {

	private ClassTranslator classTranslator = new ClassTranslatorImpl();

	@Override
	public List<Map> getMaps(List<Integer> mapIDList, ConnectOperation clientConnect) {

		List<Map> mapContractList = new ArrayList<Map>();

		try {
			mapContractList = classTranslator.getMapContractList(clientConnect.getClient().GetMaps(mapIDList,
					clientConnect.getRegID()));
		} catch (InvalidOperation e) {
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		if (mapContractList.isEmpty()) {
			MyLog.error("get All Tag infomation Failed", this.getClass().getName());
		} else {
			MyLog.info("get All Tag infomation Failed", this.getClass().getName());
		}

		// for(MapContract map:mapContractList)
		// {
		// System.out.println(map.getName() +" "+map.getMapId()
		// +" "+map.getMapFormat() +" "+map.getMaptype());
		// }

		return mapContractList;
	}

	@Override
	public List<AP> getAPs(Integer mapID, List<String> apMac, ConnectOperation clientConnect) {
		// TODO Auto-generated method stub

		List<AP> apContractList = new ArrayList<AP>();

		try {
			apContractList = classTranslator.getAPContractList(clientConnect.getClient().GetAPs(mapID, apMac,
					clientConnect.getRegID()));
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		if (apContractList.isEmpty()) {
			MyLog.error("get All Tag infomation Failed", this.getClass().getName());
		} else {
			MyLog.info("get All Tag infomation Failed", this.getClass().getName());
		}

		return apContractList;
	}

	@Override
	public List<Tag> getAllTag(ConnectOperation clientConnect) {
		// TODO Auto-generated method stub

		Integer regID = clientConnect.getRegID();
		List<Tag> tagList = new ArrayList<Tag>();
		try {
			tagList = classTranslator.getTagContractList(clientConnect.getClient().GetAllTag(regID));
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		if (tagList.isEmpty()) {
			MyLog.error("get All Tag infomation Failed",this.getClass().getName());
		} else {
			MyLog.info("get All Tag infomation Failed",this.getClass().getName());
		}
System.out.println(tagList.size());
		return tagList;
	}

}
