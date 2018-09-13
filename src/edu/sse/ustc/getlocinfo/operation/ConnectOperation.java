package edu.sse.ustc.getlocinfo.operation;

import edu.sse.ustc.contract.ILocResultService;

/**
 * a interface to define client login to GPSEngine
 * 
 * @author fqbrighter
 */
public interface ConnectOperation {

	public int connect();

	public boolean disConnect();

	public boolean ping();

	public ILocResultService.Client getClient();

	public Integer getRegID();
	
	public String getEnvironmentName();
}
