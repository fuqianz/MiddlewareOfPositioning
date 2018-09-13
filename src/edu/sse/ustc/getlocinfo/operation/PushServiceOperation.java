package edu.sse.ustc.getlocinfo.operation;


public interface PushServiceOperation {

	boolean TurnOnPushService(ConnectOperation clientConnect);

	boolean TurnOffPushService(ConnectOperation clientConnect);

}
