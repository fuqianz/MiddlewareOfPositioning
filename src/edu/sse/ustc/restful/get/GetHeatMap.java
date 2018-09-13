package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.database.returnitem.Heatmap;

public interface GetHeatMap {

	public List<Heatmap> getHeatMap(int environmentId,int mapId,String starttime,String endtime);
}
