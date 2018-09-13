package edu.sse.ustc.restful.resource.helper;

import java.util.List;

import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.restful.get.GetRealTimeResource;
import edu.sse.ustc.restful.get.impl.GetRealTimeResourceImpl;

public class RealTimeResourceHelper {

	private static GetRealTimeResource getRealTimeResource = new GetRealTimeResourceImpl();

	public static List<Stas> getAllTagScanned(int environmentid) {
		return getRealTimeResource.getAllTagScanned(environmentid);
	}

	public static List<StasPos> getAllTagScannedPos(int environmentid) {
		return getRealTimeResource.getAllTagScannedPos(environmentid);
	}

	public static List<StasPos> getAllTagScannedInMapPos(int environmentid, int mapid) {
		return getRealTimeResource.getAllTagScannedInMapPos(environmentid, mapid);
	}

	public static StasPos getTagScannedInMapPos(int environmentid, int mapid,String apMac) {
		return getRealTimeResource.getTagScannedInMapPos(environmentid, mapid,apMac);
	}
}
