package edu.sse.ustc.restful.get.impl;

import java.util.List;

import edu.sse.ustc.database.common.AcrossMap;
import edu.sse.ustc.database.common.SpaceType;
import edu.sse.ustc.database.common.StayDur;
import edu.sse.ustc.database.common.StayInfo;
import edu.sse.ustc.database.common.TagEnterTimes;
import edu.sse.ustc.database.common.TagLeaveTimes;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.stats.Fromto;
import edu.sse.ustc.database.stats.Stats;
import edu.sse.ustc.database.stats.Stayinfo;
import edu.sse.ustc.database.stats.Times;
import edu.sse.ustc.restful.get.GetStatisticsQueryResources;

public class GetStatisticsQueryResourcesImpl implements GetStatisticsQueryResources {
	
	private static Stats stats = new Stats();
	private static Times times = new Times();
	private static Fromto fromto = new Fromto();
	private static Stayinfo statsInfo = new Stayinfo();
	@Override
	public List<Stas> getAllTagContractAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return stats.getEnteredList(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public int getNumberOfAllTagAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4, String starttime,
			String endtime) {
		// TODO Auto-generated method stub
		return stats.getEnteredCount(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public List<Stas> getAllLeaveTagContractAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return stats.getLeavedList(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public int getNumberOfLeaveTagAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		// TODO Auto-generated method stub
		return stats.getLeavedCount(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public List<TagEnterTimes> getTagEnterTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return times.getEnteredList(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public int getNumberOfTimesTagAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		// TODO Auto-generated method stub
		return times.getEnteredCount(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public List<TagLeaveTimes> getTagLeaveTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return times.getLeavedList(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	}

	@Override
	public int getNumberOfTagLeaveTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		// TODO Auto-generated method stub
		return times.getLeavedCount(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime);
	
	}

	@Override
	public List<AcrossMap> getTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return fromto.getFromtotimesList(environmentid, mapid1, mapid2, starttime, endtime);
	}

	@Override
	public int getNumbersOfTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return fromto.getFromtoTimesCount(environmentid, mapid1, mapid2, starttime, endtime);
	}

	@Override
	public List<AcrossMap> getAllTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return fromto.getAllTagInfoAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
	}

	@Override
	public int getNumbersOfAllTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return fromto.getFromtoTimesCount(environmentid, mapid1, mapid2, starttime, endtime);
	}

	@Override
	public StayDur getTagStayDurInCertainMap(int environmentid, int mapid,String apMac, SpaceType type, double r1, double r2, double r3, double r4, String starttime,String endtime) {
		// TODO Auto-generated method stub
		StayDur sd = new StayDur();
		sd.setMapid(mapid);
		sd.setStayTime(statsInfo.getStayduration(environmentid, apMac, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime));
		return sd;
	}

	@Override
	public StayInfo getStayInfoOfAllTagAtCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		// TODO Auto-generated method stub
		StayInfo si = new StayInfo();
		si.setAverageStayTime(statsInfo.getStayave(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4,starttime, endtime));
		si.setStayTimeVar(statsInfo.getStayvar(environmentid, mapid, type.getValue().intValue(), r1, r2, r3, r4, starttime, endtime));
		return si;
	}

}
