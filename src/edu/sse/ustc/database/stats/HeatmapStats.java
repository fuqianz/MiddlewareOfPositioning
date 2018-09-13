package edu.sse.ustc.database.stats;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.database.dao.helper.TagPosHelper;

public class HeatmapStats {
	public List<edu.sse.ustc.database.returnitem.Heatmap> getLocationList(int environmentId,int mapId,String datetimeStart,String datetimeEnd){
		List<edu.sse.ustc.database.returnitem.Heatmap> location = new ArrayList<edu.sse.ustc.database.returnitem.Heatmap>();
		location = TagPosHelper.getLocationTimesList(environmentId, mapId, datetimeStart, datetimeEnd);
		return location;
	}

}
