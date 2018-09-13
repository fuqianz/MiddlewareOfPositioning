package edu.sse.ustc.getlocinfo.services;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.getlocinfo.common.PropertiesReader;

/**
 * 
 * @author fqbrighter
 * @function connect to server
 */
public class ConnectLocServer {

	private TTransport transport = null;
	private TProtocol protocol = null;

	public ConnectLocServer() {
		transport = new TSocket(PropertiesReader.getServerIP(), PropertiesReader.getRpcPort());
		protocol = new TBinaryProtocol(transport);
	}

	public void openTransport() {

		if (transport.isOpen())
			return;

		try {
			transport.open();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}
	}

	public void closeTransport() {

		transport.close();
		MyLog.info("thrift transport closed successful", this.getClass().getName());
	}

	public TTransport getTransport() {
		return transport;
	}

	public void setTransport(TTransport transport) {
		this.transport = transport;
	}

	public TProtocol getProtocol() {
		return protocol;
	}

	public void setProtocol(TProtocol protocol) {
		this.protocol = protocol;
	}
}
