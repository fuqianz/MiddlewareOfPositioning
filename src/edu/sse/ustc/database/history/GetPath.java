package edu.sse.ustc.database.history;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.returnitem.StaPath;
import edu.sse.ustc.database.returnitem.StasPath;
import edu.sse.ustc.innerclass.TagPos;


public class GetPath {
	
	public List<StasPath> getPathInEnviroment(int environmentId,String datetimeStart,String datetimeEnd){	
		List <StasPath> path = new ArrayList<StasPath>();
		List<String> tags  = TagPosHelper.getMacListByTimendEnvironment(environmentId, datetimeStart, datetimeEnd);
		
		for(String s : tags){
			List <StaPath> points = new ArrayList<StaPath>();
			StasPath items = new StasPath();
			List <TagPos> tagListReal = TagPosHelper.getChosenTagListByTime(s,datetimeStart, datetimeEnd);
			for(TagPos fin : tagListReal){
				StaPath item = new StaPath();
				item.setMap_id(fin.getMapId());
				item.setEnvironment_id(fin.getEnvironmentId());
				item.setPos_x(fin.getX_pos());
				item.setPos_y(fin.getY_pos());
				item.setPos_z(fin.getZ_pos());				
				points.add(item);				
				}
			items.setSta_path(points);
			items.setSta_mac(s);
			path.add(items);
		}
		return path;
	}
	
	public List<StasPath> getPathInMap(int environmentId,int mapId,String datetimeStart,String datetimeEnd){	
		List <StasPath> path = new ArrayList<StasPath>();
		List<String> tags = TagPosHelper.getMacListByTimeAndMap(environmentId, mapId, datetimeStart, datetimeEnd);
		for(String s : tags){
			List <StaPath> points = new ArrayList<StaPath>();
			List <TagPos> tagListReal = TagPosHelper.getChosenTagListByTime(s,datetimeStart, datetimeEnd);
			for(TagPos fin : tagListReal){
				StaPath item = new StaPath();
				item.setMap_id(fin.getMapId());
				item.setEnvironment_id(fin.getEnvironmentId());
				item.setPos_x(fin.getX_pos());
				item.setPos_y(fin.getY_pos());
				item.setPos_z(fin.getZ_pos());				
				points.add(item);				
				}
			StasPath items = new StasPath();
			items.setSta_path(points);
			items.setSta_mac(s);
			path.add(items);
		}
		return path;
	}
	
	public StasPath getStasPathInMap(String mac,String datetimeStart,String datetimeEnd){	
		List <StaPath> point = new ArrayList<StaPath>();
		StasPath items = new StasPath();
			List <TagPos> tagListReal = TagPosHelper.getChosenTagListByTime(mac,datetimeStart, datetimeEnd);
			for(TagPos fin : tagListReal){
				StaPath item = new StaPath();
				item.setMap_id(fin.getMapId());
				item.setEnvironment_id(fin.getEnvironmentId());
				item.setPos_x(fin.getX_pos());
				item.setPos_y(fin.getY_pos());
				item.setPos_z(fin.getZ_pos());		
				point.add(item);	
				}
			items.setSta_path(point);
			items.setSta_mac(mac);
				
		return items;
	}
	

	
}
