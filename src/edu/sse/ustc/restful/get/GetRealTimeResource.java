package edu.sse.ustc.restful.get;

import java.util.List;

import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.returnitem.StasPos;

public interface GetRealTimeResource {

	public List<Stas> getAllTagScanned(int environmentid);

	public List<StasPos> getAllTagScannedPos(int environmentid);

	public List<StasPos> getAllTagScannedInMapPos(int environmentid, int mapid);

	public StasPos getTagScannedInMapPos(int environmentid, int mapid,String apMac);
}
