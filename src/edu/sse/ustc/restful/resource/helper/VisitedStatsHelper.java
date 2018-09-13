package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.database.returnitem.DayMac;
import edu.sse.ustc.database.returnitem.VisitedTimes;
import edu.sse.ustc.restful.get.GetVisitedStats;
import edu.sse.ustc.restful.get.impl.GetVisitedStatsImpl;

public class VisitedStatsHelper {

	private static GetVisitedStats getVisitedStats = new GetVisitedStatsImpl();

	public static VisitedTimes getVisitedTimesInEnvironment(int environmentId, String start, String end) {
		return getVisitedStats.getVisitedTimesInEnvironment(environmentId, start, end);
	}

	public static VisitedTimes getVisitedTimesInMap(int environmentId, int mapId,String start, String end) {
		return getVisitedStats.getVisitedTimesInMap(environmentId,mapId, start, end);
	}
	
	public static List<DayMac> getDayMacCount(int environmentId, int mapId,int type,double r1,double r2,double r3,double r4,String start, String end){
		return getVisitedStats.getDayMacCount(environmentId, mapId, type, r1, r2, r3, r4, start, end);
	}

}
