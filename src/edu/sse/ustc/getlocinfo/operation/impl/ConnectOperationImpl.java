package edu.sse.ustc.getlocinfo.operation.impl;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.contract.ILocResultService;
import edu.sse.ustc.contract.InvalidOperation;
import edu.sse.ustc.getlocinfo.common.PropertiesReader;
import edu.sse.ustc.getlocinfo.operation.ConnectOperation;
import edu.sse.ustc.getlocinfo.services.ConnectLocServer;

public class ConnectOperationImpl implements ConnectOperation {

	private ILocResultService.Client client = null;
	private String environmentName = null;
	private Integer regID = -2;
	private ConnectLocServer connectToServer = null;

	public ConnectOperationImpl() {

		// connect to thrift server
		connectToServer = new ConnectLocServer();

		TProtocol prot = connectToServer.getProtocol();

		// open transport tunnel
		connectToServer.openTransport();

		client = new ILocResultService.Client(prot);

		environmentName = PropertiesReader.getEnvironmentName();
	}

	/**
	 * connect to server and get the regID
	 */
	@Override
	public int connect() {

		try {
			regID = client.Connect(environmentName);
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			if(regID != -1) regID = -2;
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			if(regID != -1) regID = -2;
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}
		
		return regID;
	}

	/**
	 * logout from server
	 */
	@Override
	public boolean disConnect() {

		Integer success = null;
		try {
			success = client.DisConnect(regID);
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		/*
		 * close transport tunnel
		 */

		connectToServer.closeTransport();

		return (success == 1);
	}

	/**
	 * verify whether server is connect with server use regID
	 */
	@Override
	public boolean ping() {

		Integer success = -2;
		try {
			success = client.Ping(regID);
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return (success == 1);
	}

	public ILocResultService.Client getClient() {
		return client;
	}

	public void setClient(ILocResultService.Client client) {
		this.client = client;
	}

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public void setRegID(Integer regID) {
		this.regID = regID;
	}

	public Integer getRegID() {
		return regID;
	}
}
