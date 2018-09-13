package edu.sse.ustc.database.realtime;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.database.returnitem.StasPos;
import edu.sse.ustc.innerclass.TagPos;

public class GetRealTimeTags {
	
	public List<Stas> getAllTagScanned(int environmentid){
		List<TagPos> list = TagPosHelper.getLatestPosByEnvironment(environmentid);
		List<Stas> result = new ArrayList<Stas>();
		for(TagPos rs:list){
			if(rs.getMapId()!=-1&&rs.getX_pos()!=-1&&rs.getY_pos()!=-1){
				Stas tag = new Stas();
				tag.setSta_mac(rs.getMac());
				tag.setLast_scaned_time(rs.getTime().toString());
				tag.setSta_vendor(Helper.getVendor(rs.getMac()));
				result.add(tag);
			}
		}
		return result;
	}
	
	public List<StasPos> getAllTagScannedPos(int environmentid){
		List<TagPos> list = TagPosHelper.getLatestPosByEnvironment(environmentid);
		List<StasPos> result = new ArrayList<StasPos>();
		for(TagPos rs:list){
			if(rs.getMapId()!=-1&&rs.getX_pos()!=-1&&rs.getY_pos()!=-1){
				StasPos pos = new StasPos();
				pos.setSta_mac(rs.getMac());
				pos.setEnvironment_id(rs.getEnvironmentId());
				pos.setMap_id(rs.getMapId());
				pos.setPos_x(rs.getX_pos());
				pos.setPos_y(rs.getY_pos());
				pos.setPos_z(rs.getZ_pos());
				pos.setDatetime(rs.getTime().toString());
				result.add(pos);
			}
		}
		return result;
	}
	
	public List<StasPos> getAllTagScannedInMapPos(int environmentid, int mapid){
		List<TagPos> list = TagPosHelper.getLatestPosByMap(environmentid, mapid);
		List<StasPos> result = new ArrayList<StasPos>();
		for(TagPos rs:list){
			if(rs.getMapId()!=-1&&rs.getX_pos()!=-1&&rs.getY_pos()!=-1){
				StasPos pos = new StasPos();
				pos.setSta_mac(rs.getMac());
				pos.setEnvironment_id(rs.getEnvironmentId());
				pos.setMap_id(rs.getMapId());
				pos.setPos_x(rs.getX_pos());
				pos.setPos_y(rs.getY_pos());
				pos.setPos_z(rs.getZ_pos());
				pos.setDatetime(rs.getTime().toString());
				result.add(pos);
			}
		}
		return result;
	}
	
	public StasPos getTagScannedInMapPos(int environmentid, int mapid, String apMac){
		TagPos rs = TagPosHelper.getLatestPosByMac(environmentid, mapid, apMac);
		StasPos pos = new StasPos();
		pos.setSta_mac(rs.getMac());
		pos.setEnvironment_id(rs.getEnvironmentId());
		pos.setMap_id(rs.getMapId());
		pos.setPos_x(rs.getX_pos());
		pos.setPos_y(rs.getY_pos());
		pos.setPos_z(rs.getZ_pos());
		pos.setDatetime(rs.getTime().toString());
		return pos;
	}
}
