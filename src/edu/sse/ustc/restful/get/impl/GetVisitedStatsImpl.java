package edu.sse.ustc.restful.get.impl;

import java.util.List;

import edu.sse.ustc.database.returnitem.DayMac;
import edu.sse.ustc.database.returnitem.VisitedTimes;
import edu.sse.ustc.database.stats.DayMacCount;
import edu.sse.ustc.database.stats.VisitedStats;
import edu.sse.ustc.restful.get.GetVisitedStats;

public class GetVisitedStatsImpl implements GetVisitedStats {

	private VisitedStats getVisitedStats = new VisitedStats();

	@Override
	public VisitedTimes getVisitedTimesInEnvironment(int environmentId, String start, String end) {
		// TODO Auto-generated method stub
		return getVisitedStats.getVisitedTimesinEnvironment(environmentId, start, end);
	}

	@Override
	public VisitedTimes getVisitedTimesInMap(int environmentId, int mapId, String start, String end) {
		// TODO Auto-generated method stub
		return getVisitedStats.getVisitedTimesinMap(environmentId, mapId, start, end);
	}
	
	public List<DayMac> getDayMacCount(int environmentId,int mapId,int type,double r1,double r2,double r3,double r4,String start,String end){
		
		return new DayMacCount().getEverydayMacCountInMap(environmentId, mapId, type,r1, r2, r3, r4,  start, end);

	}


}
