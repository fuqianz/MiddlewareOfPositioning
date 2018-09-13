package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.database.returnitem.DayMac;
import edu.sse.ustc.database.returnitem.VisitedTimes;

public interface GetVisitedStats {
	
	public VisitedTimes getVisitedTimesInEnvironment(int environmentId,String start,String end);
	public VisitedTimes getVisitedTimesInMap(int environmentId,int mapId,String start,String end);
	public List<DayMac> getDayMacCount(int environmentId,int mapId,int type,double r1,double r2,double r3,double r4,String start,String end);

}
