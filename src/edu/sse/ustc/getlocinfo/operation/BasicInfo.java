package edu.sse.ustc.getlocinfo.operation;

import java.util.Date;
import java.util.List;

import edu.sse.ustc.innerclass.Environment;

/**
 * 
 * get basic information from server
 * @author fqbrighter
 *
 */
public interface BasicInfo {

	public Date getServerTime(ConnectOperation clientConnect);
	public List<Environment> getAllEnvironments(ConnectOperation clientConnect);
}
