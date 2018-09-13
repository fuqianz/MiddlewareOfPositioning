package edu.sse.ustc.getlocinfo.services;

import java.util.HashMap;
import java.util.List;

import edu.sse.ustc.database.dao.helper.MapHelper;
import edu.sse.ustc.innerclass.Map;

public class ReadHelper {

	private static java.util.Map<Integer, Integer> help = new HashMap<Integer,Integer>();

	public static Integer getEnvironmentId(int mapId) {

		if (help == null || help.isEmpty()) {
			loadMap();
		}

		return help.get(mapId);
	}

	public static int loadMap() {

		List<Map> lmp = MapHelper.getMap();
        
		//System.out.println(lmp.toString());
	    if(lmp == null) return 1;
		
		for (int i = 0;  i < lmp.size(); i++) {
			//System.out.println(lmp.get(i).getMapId()+" "+lmp.get(i).getEnvironmentId());
			help.put(lmp.get(i).getMapId(), lmp.get(i).getEnvironmentId());
		}
		
		return lmp.size();
	}
	
	// public static void main(String[] args)
	// {
	// System.out.println(ReadHelper.getEnvironmentId(1));
	// System.out.println(ReadHelper.getEnvironmentId(2));
	// System.out.println(ReadHelper.getEnvironmentId(3));
	// System.out.println(ReadHelper.getEnvironmentId(4));
	// System.out.println(ReadHelper.getEnvironmentId(5));
	//
	// }
}
