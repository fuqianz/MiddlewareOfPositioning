package edu.sse.ustc.getlocinfo;

import java.net.SocketException;
import java.net.UnknownHostException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.getlocinfo.common.PropertiesReader;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.operation.SocketService;

public class SocketManager implements Runnable {

	private SocketService socketService = new SocketService();
	private ConnectOperation co;
	private boolean flag = false;
	
	public ConnectOperation getConnectOperation() {
		return co;
	}

	public void setConnectOperation(ConnectOperation co) {
		this.co = co;
	}



	public void bindToServer() {
		try {
			socketService.bindServer();
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			MyLog.error(e.toString(), this.getClass().getName());
		}
	}

	public void requestForService(ConnectOperation co, int port, String ip) {
		flag = socketService.requestForBind(co, port, ip);
	}

	public void requestForService(ConnectOperation co) {
		flag = socketService.requestForBind(co, PropertiesReader.getSocketPort(), PropertiesReader.getServerIP());
	}

	public void getAndSaveRealTimePos(ConnectOperation co) {

		// new SocketService().getPathInfo(ConnectOperation, port, ip);

		if (flag) {

			socketService.getAndSavePathInfo(co);
		} else {
			// client connect fail;
			MyLog.error("Open Socket Service Failed!", this.getClass().getName());
		}
	}

	public void close() {

		socketService.close();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.bindToServer();
		this.requestForService(co);
		this.getAndSaveRealTimePos(co);

	}
}
