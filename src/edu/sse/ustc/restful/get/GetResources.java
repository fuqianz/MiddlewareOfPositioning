package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.myenum.DevStatus;

public interface GetResources {
	
	public List<Environment> getAllEnvironment();
	
	public Environment getEnvironmentById(int environmentid);

    public List<Map> getAllMapsAtEnvironment(int environmentid);
	
	public Map getEnvironmentMap(int environmentid,int mapid);
	
	public String getCurrentSysDateTime();
	
	public List<AP> getAp(int environmentid,int mapid);
	
	public AP getApContract(int environmentid,int mapid,String apMac);

	public DevStatus getAPStatus(int environmentid,int mapid,String apMac);
}
