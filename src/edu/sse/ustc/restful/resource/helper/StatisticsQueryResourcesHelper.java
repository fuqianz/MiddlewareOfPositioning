package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.database.common.AcrossMap;
import edu.sse.ustc.database.common.SpaceType;
import edu.sse.ustc.database.common.StayDur;
import edu.sse.ustc.database.common.StayInfo;
import edu.sse.ustc.database.common.TagEnterTimes;
import edu.sse.ustc.database.common.TagLeaveTimes;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.restful.get.GetStatisticsQueryResources;
import edu.sse.ustc.restful.get.impl.GetStatisticsQueryResourcesImpl;

public class StatisticsQueryResourcesHelper {

	private static GetStatisticsQueryResources getStatisticsQueryResources = new GetStatisticsQueryResourcesImpl();

	public static List<Stas> getAllTagContractAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return getStatisticsQueryResources.getAllTagContractAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static int getNumberAllTagContractAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		return getStatisticsQueryResources.getNumberOfAllTagAtTimeAndMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static List<Stas> getAllLeaveTagContractAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return getStatisticsQueryResources.getAllLeaveTagContractAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static int getNumberOfLeaveTagContractAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		return getStatisticsQueryResources.getNumberOfLeaveTagAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static List<TagEnterTimes> getTagEnterTimesAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return getStatisticsQueryResources.getTagEnterTimesAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static int getNumberOfTimesTagAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		return getStatisticsQueryResources.getNumberOfTimesTagAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static List<TagLeaveTimes> getTagLeaveTimesAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return getStatisticsQueryResources.getTagLeaveTimesAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static int getNumberOfTagLeaveTimesAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime) {
		return getStatisticsQueryResources.getNumberOfTagLeaveTimesAtTimeAndCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

	public static List<AcrossMap> getTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		return getStatisticsQueryResources.getTagInfoAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
	}

	public static int getNumbersOfTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		return getStatisticsQueryResources.getNumbersOfTagAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
	}

	public static List<AcrossMap> getAllTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		return getStatisticsQueryResources.getAllTagInfoAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
	}

	public static int getNumbersOfAllTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime) {
		return getStatisticsQueryResources.getNumbersOfAllTagAcrossTwoMapsAtTimes(environmentid, mapid1, mapid2, starttime, endtime);
	}

	public static StayDur getTagStayDurInMap(int environmentid, int mapid,String apMac, SpaceType type, double r1, double r2, double r3, double r4, String starttime, String endtime) {
             return getStatisticsQueryResources.getTagStayDurInCertainMap(environmentid,mapid,apMac,type,r1,r2,r3,r4,starttime,endtime);
	}
	
	public static StayInfo getStayInfoOfAllTag(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime) {
		return getStatisticsQueryResources.getStayInfoOfAllTagAtCertainMapSpace(environmentid, mapid, type, r1, r2, r3, r4, starttime, endtime);
	}

}
