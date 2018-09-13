package edu.sse.ustc.database.dao.helper;
import java.util.List;

import edu.sse.ustc.database.dao.TagPosDao;
import edu.sse.ustc.innerclass.TagPos;

public class TagPosHelper {
	private static TagPosDao getTagPos = new TagPosDao();
	
	public static List<TagPos> getTagPos(){
		return getTagPos.getTagPos();
	}
	
	public static List<Integer> getTagPosId(){
		return getTagPos.getTagPosId();
	}
	
	public static TagPos getPosListByMacAndChosenTime(String sta_mac, String datetime){
		return getTagPos.getPosListByMacAndChosenTime(sta_mac, datetime);
	}
		
	public static TagPos getPosListByMacAndTime(String sta_mac, String datetime){
		return getTagPos.getPosListByMacAndTime(sta_mac, datetime);
	}
	
	public static List<TagPos> getPosListByTimeAndEnvironment(int enviromentId, String datetime){
		return getTagPos.getPosListByTimeAndEnvironment(enviromentId, datetime);
	}
	
	public static List<TagPos> getPosListByTimeAndMap(int enviromentId, int mapId, String datetime){
		return getTagPos.getPosListByTimeAndMap(enviromentId, mapId, datetime);
	}
	
	public static List<TagPos> getTagListByTime(int enviromentId, int mapId, String datetimeStart, String datetimeEnd){
		return getTagPos.getTagListByTime(enviromentId, mapId, datetimeStart, datetimeEnd);
	}
	
	public static List<TagPos> getTagListByTime2(int enviromentId, String datetimeStart, String datetimeEnd){
		return getTagPos.getTagListByTime2(enviromentId, datetimeStart, datetimeEnd);
	}
	
	public static List<String> getMacListByTimeAndMap (int environmentId,int mapId,String datetimeStart, String datetimeEnd){
		return getTagPos.getMacListByTimeAndMap(environmentId, mapId, datetimeStart, datetimeEnd);
	}
	
	public static List<String> getMacListByTimendEnvironment(int environmentId, String datetimeStart, String datetimeEnd){
		return getTagPos.getMacListByTimendEnvironment(environmentId, datetimeStart, datetimeEnd);
	}
	public static List<TagPos> getChosenTagListByTime(String mac, String datetimeStart, String datetimeEnd){
		return getTagPos.getChosenTagListByTime(mac, datetimeStart, datetimeEnd);
	}
	
	public static List<TagPos> getLatestPosByEnvironment(int environmentId){
		return getTagPos.getLatestPosByEnvironment(environmentId);
	}
	
	public static List<TagPos> getLatestPosByMap(int environmentId,int mapId){
		return getTagPos.getLatestPosByMap(environmentId, mapId);
	}
	
	public static TagPos getLatestPosByMac(int environmentId,int mapId,String mac){
		return getTagPos.getLatestPosByMac(environmentId, mapId, mac);
	}
	
	public static TagPos getLastTimeTag(String mac, String time){
		return getTagPos.getLastTimeTag(mac, time);
	}
	
	public static TagPos getNextTimeTag(String mac, String time){
		return getTagPos.getNextTimeTag(mac, time);
	}
	
	public static boolean newTagPos(List<TagPos> aps){
		return getTagPos.newTagPos(aps);
	}
	
	public static void delTagPos(String mac, String time){
		getTagPos.delTagPos(mac, time);
	}
	
	public static List<edu.sse.ustc.database.returnitem.Heatmap>getLocationTimesList(int environmentId,int mapId,String datetimeStart,String datetimeEnd){
		return getTagPos.getLocationTimesList(environmentId, mapId, datetimeStart, datetimeEnd);
	}
}
