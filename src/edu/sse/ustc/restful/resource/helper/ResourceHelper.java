package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.myenum.DevStatus;
import edu.sse.ustc.restful.get.GetResources;
import edu.sse.ustc.restful.get.impl.GetResourcesImpl;

public class ResourceHelper {
	
	private static GetResources getResources = new GetResourcesImpl();
	
	public static List<Environment> getAllEnvironment()
	{
		return getResources.getAllEnvironment();
	}

	public static List<Map> getAllMapsAtEnvironment(int environmentid)
	{
	    return getResources.getAllMapsAtEnvironment(environmentid);
	}
	
	public static Environment getEnvironment(int id)
	{
		return getResources.getEnvironmentById(id);
	}
	
	public static Map getEnvironmentMap(int environmentid,int mapid){
		return getResources.getEnvironmentMap(environmentid, mapid);
	}
	
	public static AP getAPContract(int environmentid,int mapid,String apMac){
		return getResources.getApContract(environmentid, mapid, apMac);
	}
	
	public static List<AP> getAP(int environmentid,int mapid){
		return getResources.getAp(environmentid, mapid);
	}

	public static DevStatus getAPStatus(int environmentid,int mapid,String apMac){
		return getResources.getAPStatus(environmentid, mapid, apMac);
	}
	public static String getCurrentSysDatetime()
	{
		return getResources.getCurrentSysDateTime();
	}
	
	
}
