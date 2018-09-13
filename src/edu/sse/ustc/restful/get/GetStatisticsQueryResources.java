package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.database.common.AcrossMap;
import edu.sse.ustc.database.common.SpaceType;
import edu.sse.ustc.database.common.StayDur;
import edu.sse.ustc.database.common.StayInfo;
import edu.sse.ustc.database.common.TagEnterTimes;
import edu.sse.ustc.database.common.TagLeaveTimes;
import edu.sse.ustc.database.returnitem.Stas;

public interface GetStatisticsQueryResources {
	/**
	 *
	 * 
	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<Stas> getAllTagContractAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumberOfAllTagAtTimeAndMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4, String starttime,
			String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<Stas> getAllLeaveTagContractAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumberOfLeaveTagAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<TagEnterTimes> getTagEnterTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumberOfTimesTagAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<TagLeaveTimes> getTagLeaveTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3,
			double r4, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumberOfTagLeaveTimesAtTimeAndCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime);

	/**
 
	 * @param environmentid
	 * @param mapid1
	 * @param mapid2
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<AcrossMap> getTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime);

	/**
 
	 * @param environmentid
	 * @param mapid1
	 * @param mapid2
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumbersOfTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid1
	 * @param mapid2
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<AcrossMap> getAllTagInfoAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime);

	/**

	 * @param environmentid
	 * @param mapid1
	 * @param mapid2
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public int getNumbersOfAllTagAcrossTwoMapsAtTimes(int environmentid, int mapid1, int mapid2, String starttime, String endtime);

	/**
	
	 * @param apMac
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public StayDur getTagStayDurInCertainMap(int environmentid, int mapid,String apMac, SpaceType type, double r1, double r2, double r3, double r4, String starttime, String endtime);

	/**
	* @param environmentid
	 * @param mapid
	 * @param type
	 * @param r1
	 * @param r2
	 * @param r3
	 * @param r4
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public StayInfo getStayInfoOfAllTagAtCertainMapSpace(int environmentid, int mapid, SpaceType type, double r1, double r2, double r3, double r4,
			String starttime, String endtime);
}
