package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.restful.get.GetHistoryResources;
import edu.sse.ustc.restful.get.impl.GetHistoryResourcesImpl;

public class HistoryResourcesHelper {

	private static GetHistoryResources getHistoryResources = new GetHistoryResourcesImpl();

	public static List<StasPos> getTagPosAtTime(int environmentid, String Stringtime) {
		return getHistoryResources.getTagPosAtCertainTime(environmentid, Stringtime);
	}

	public static List<StasPath> getTagPathTimes(int environmentid, String starttime, String endtime) {
		return getHistoryResources.getTagPathAtOneCertainTime(environmentid, starttime, endtime);
	}

	public static List<StasPos> getTagPosAtTimeAndMap(int environmentid, int mapid, String Stringtime){
		return getHistoryResources.getTagPosAtCertainTimeAndMap(environmentid,mapid,Stringtime);
	}
	
	public static List<StasPath> getAllTagPosAtTimeAndMap(int environmentid, int mapid, String starttime,String endtime){
		return getHistoryResources.getAllTagPathAtCertainTimeAndMap(environmentid,mapid,starttime,endtime);
	}
	
	public static StasPos getTagLocContractAtTime(String apMac,String Stringtime){
	    
	    System.out.println(apMac+" "+Stringtime);
	    
		return getHistoryResources.getTagLocContractAtCertainTime(apMac,Stringtime);
	}
	
	public static StasPath getTagPathContractAtTime(String apMac,String starttime,String endtime){
        return getHistoryResources.getCertainTagPathContractAtTime(apMac,starttime,endtime); 		
	}
}
