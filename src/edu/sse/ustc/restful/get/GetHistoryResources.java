package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.database.returnitem.StasPos;

public interface GetHistoryResources {
	/**
	 * 
	 * @param environmentid
	 * @param datetime
	 * @return
	 */
	public List<StasPos> getTagPosAtCertainTime(int environmentid, String datetime);

	/**
	
	 * 
	 * @param environmentid
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<StasPath> getTagPathAtOneCertainTime(int environmentid, String starttime, String endtime);

	/**
	 * 
	 * 
	 * @param environmentid
	 * @param mapid
	 * @param datetime
	 * @return
	 */
	public List<StasPos> getTagPosAtCertainTimeAndMap(int environmentid, int mapid, String datetime);

	/**
	 * 
	 * @param environmentid
	 * @param mapid
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<StasPath> getAllTagPathAtCertainTimeAndMap(int environmentid, int mapid, String starttime, String endtime);
    /**
     * 
     * @param apMac
     * @param datetime
     * @return
     */
	public StasPos getTagLocContractAtCertainTime(String apMac,String datetime);
	
	/**
	 * 
	 * @param apMac
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public StasPath getCertainTagPathContractAtTime(String apMac,String starttime,String endtime);
}
