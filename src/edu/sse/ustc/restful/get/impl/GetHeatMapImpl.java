package edu.sse.ustc.restful.get.impl;

import java.util.List;

import edu.sse.ustc.database.returnitem.Heatmap;
import edu.sse.ustc.database.stats.HeatmapStats;
import edu.sse.ustc.restful.get.GetHeatMap;

public class GetHeatMapImpl implements GetHeatMap {

	private static HeatmapStats getHeatMap = new HeatmapStats();
	@Override
	public List<Heatmap> getHeatMap(int environmentId, int mapId, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return getHeatMap.getLocationList(environmentId, mapId, starttime, endtime);
	}

}
