package edu.sse.ustc.restful.get.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.history.GetPath;
import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.innerclass.TagPos;
import edu.sse.ustc.restful.get.GetHistoryResources;

public class GetHistoryResourcesImpl implements GetHistoryResources {
	
	private static GetPath getPath = new GetPath();
	@Override
	public List<StasPos> getTagPosAtCertainTime(int environmentid, String datetime) {
		// TODO Auto-generated method stub
		List<TagPos> list = TagPosHelper.getPosListByTimeAndEnvironment(environmentid,datetime);
		List<StasPos> rs = new ArrayList<StasPos>();
		for(TagPos item : list){
			 StasPos loc = new StasPos();
			 loc.setSta_mac(item.getMac());
			 loc.setEnvironment_id(item.getEnvironmentId());
			 loc.setMap_id(item.getMapId());
			 loc.setPos_x(item.getX_pos());
			 loc.setPos_y(item.getY_pos());
			 loc.setPos_z(item.getZ_pos());
			 loc.setDatetime(item.getTime().toString());
			 rs.add(loc);
		}
		return rs;
	}

	@Override
	public List<StasPath> getTagPathAtOneCertainTime(int environmentid, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return getPath.getPathInEnviroment(environmentid, starttime, endtime);
	}

	@Override
	public List<StasPos> getTagPosAtCertainTimeAndMap(int environmentid, int mapid, String datetime) {
		// TODO Auto-generated method stub
		List<TagPos> list = TagPosHelper.getPosListByTimeAndMap(environmentid, mapid, datetime);
		List<StasPos> rs = new ArrayList<StasPos>();
		for(TagPos item : list){
			 StasPos loc = new StasPos();
			 loc.setSta_mac(item.getMac());
			 loc.setEnvironment_id(item.getEnvironmentId());
			 loc.setMap_id(item.getMapId());
			 loc.setPos_x(item.getX_pos());
			 loc.setPos_y(item.getY_pos());
			 loc.setPos_z(item.getZ_pos());
			 loc.setDatetime(item.getTime().toString());
			 rs.add(loc);
		}
		return rs;
	}

	@Override
	public List<StasPath> getAllTagPathAtCertainTimeAndMap(int environmentid, int mapid, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return getPath.getPathInMap(environmentid, mapid, starttime, endtime);
	}

	@Override
	public StasPos getTagLocContractAtCertainTime(String apMac, String datetime) {
		// TODO Auto-generated method stub
		TagPos item = TagPosHelper.getPosListByMacAndTime(apMac, datetime);
		 StasPos loc = new StasPos();
		 loc.setSta_mac(item.getMac());
		 loc.setEnvironment_id(item.getEnvironmentId());
		 loc.setMap_id(item.getMapId());
		 loc.setPos_x(item.getX_pos());
		 loc.setPos_y(item.getY_pos());
		 loc.setPos_z(item.getZ_pos());
		 loc.setDatetime(item.getTime().toString());		
		 return loc;
	}

	@Override
	public StasPath getCertainTagPathContractAtTime(String apMac, String starttime, String endtime) {
		// TODO Auto-generated method stub
		return getPath.getStasPathInMap(apMac, starttime, endtime);
	}

}
