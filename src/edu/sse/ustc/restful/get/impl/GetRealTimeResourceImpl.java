package edu.sse.ustc.restful.get.impl;

import java.util.List;

import edu.sse.ustc.database.realtime.GetRealTimeTags;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.restful.get.GetRealTimeResource;


public class GetRealTimeResourceImpl implements GetRealTimeResource {

    private static GetRealTimeTags getRealTime = new GetRealTimeTags();
    @Override
    public List<Stas> getAllTagScanned(int environmentid) {
        // TODO Auto-generated method stub
        return  getRealTime.getAllTagScanned(environmentid);
    }

    @Override
    public List<StasPos> getAllTagScannedPos(int environmentid) {
        // TODO Auto-generated method stub
        return getRealTime.getAllTagScannedPos(environmentid);
    }

    @Override
    public List<StasPos> getAllTagScannedInMapPos(int environmentid, int mapid) {
        // TODO Auto-generated method stub
        return getRealTime.getAllTagScannedInMapPos(environmentid, mapid);
    }

    @Override
    public StasPos getTagScannedInMapPos(int environmentid, int mapid, String apMac) {
        // TODO Auto-generated method stub
        return getRealTime.getTagScannedInMapPos(environmentid, mapid, apMac);
    }

}
