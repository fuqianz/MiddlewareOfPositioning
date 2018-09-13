package edu.sse.ustc.manager;

import edu.sse.ustc.database.save.ThreadManager;
import edu.sse.ustc.getlocinfo.RPCServerManager;
import edu.sse.ustc.getlocinfo.SocketManager;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.restful.app.RestJaxRsServer;

public class Server {

	public static void start() {

		// restful server
		RestJaxRsServer.run();
		RPCServerManager rpcs = new RPCServerManager();
		ConnectOperation co = null;
		ThreadManager.tagPositionManager();

		while (true) {
			// open rpc and get basic data

			if (co == null || !co.ping()) {

				co = rpcs.openConnect();
				rpcs.saveBasicApsData(-1, null, co);
				rpcs.saveBasicMapsData(null, co);
				rpcs.saveBasicEnvironmentsInfo(co);
				rpcs.saveBasicTagData(co);

				// turn on socket push service
				rpcs.TurnOnSocketService(co);

				SocketManager socketManager = new SocketManager();
				socketManager.setConnectOperation(co);

				Thread thread = new Thread(socketManager);
				thread.start();

			}

			try {
				Thread.sleep(60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		Server.start();
	}

}
