package edu.sse.ustc.database.dao.helper;

import java.util.List;

import edu.sse.ustc.database.dao.MapDao;
import edu.sse.ustc.innerclass.Map;
public class MapHelper {
	
	private static MapDao getMap = new MapDao();
	
	public static List<Map> getMap() {
		return getMap.getMap();
	}
	
    public static List<Map> getMap(int environmentid) {
        return getMap.getMap(environmentid);
    }
	public static List<Integer> getMapId(){
		return getMap.getMapId();
	}
	
	public static Map getMapByMapId(int environmentId,int mapId){
		return getMap.getMapByMapId(environmentId, mapId);
	}

	public static boolean newMap(List<Map> mps){
		return getMap.newMap(mps);
	}

//	public static void updateMap(int mapId,int environmentId, String name, int mapType, int mapFormat, int mapSizeInByte, int width, int height, int scale, String remark,
//			String mapImageName){
//		getMap.updateMap(mapId, environmentId, name, mapType, mapFormat, mapSizeInByte, width, height, scale, remark, mapImageName);
//	}
	
	public static void delMap(int mapId){
		getMap.delMap(mapId);
	}
}
