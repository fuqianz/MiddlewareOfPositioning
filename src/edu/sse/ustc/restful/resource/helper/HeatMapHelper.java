package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.database.returnitem.Heatmap;
import edu.sse.ustc.restful.get.GetHeatMap;
import edu.sse.ustc.restful.get.impl.GetHeatMapImpl;

public class HeatMapHelper {
	private static GetHeatMap getHeatMap = new GetHeatMapImpl();

	public static List<Heatmap> getHeatMap(int environmentId, int mapId, String starttime, String endtime) {
		return getHeatMap.getHeatMap(environmentId, mapId, starttime, endtime);
	}
}
