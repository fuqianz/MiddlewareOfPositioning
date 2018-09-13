package edu.sse.ustc.getlocinfo.operation.impl;

import org.apache.thrift.TException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.contract.InvalidOperation;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.operation.PushServiceOperation;

public class PushServiceOperationImpl implements PushServiceOperation {

	public PushServiceOperationImpl() {
	}

	@Override
	public boolean TurnOnPushService(ConnectOperation clientConnect) {
		// TODO Auto-generated method stub
		boolean success = true;

		try {
			success = clientConnect.getClient().TurnOnPushService(clientConnect.getRegID());
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean TurnOffPushService(ConnectOperation clientConnect) {
		// TODO Auto-generated method stub
		boolean success = true;

		try {
			success = clientConnect.getClient().TurnOffPushService(clientConnect.getRegID());
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}
		return success;
	}

}
