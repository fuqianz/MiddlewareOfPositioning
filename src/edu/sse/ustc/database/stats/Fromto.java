package edu.sse.ustc.database.stats;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.database.common.AcrossMap;
import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.innerclass.TagPos;
public class Fromto {
	//缁熻鏌愭鏃堕棿鍐呬粠鍦板浘A鍒板湴鍥綛鐨勪汉娆″垪琛�
	public List<AcrossMap> getFromtotimesList(int environmentId,int mapId1,int mapId2,String starttime,String endtime){
				List<AcrossMap> rs = new ArrayList<AcrossMap>();
				//鏌ヨ鏃堕棿娈靛唴鏇惧畾浣嶅湪鍦板浘B鐨勮澶囧垪琛�
				List<String> tagListReal = TagPosHelper.getMacListByTimeAndMap(environmentId, mapId2, starttime, endtime);
				for(String res:tagListReal){
					List<TagPos> list = new ArrayList<TagPos>();
					list = TagPosHelper.getChosenTagListByTime(res, starttime, endtime);//鑾峰彇鍒楄〃涓殑涓�涓澶囧湪鏃堕棿娈靛唴鐨勬墍鏈変綅缃俊鎭�
					//閬嶅巻浣嶇疆淇℃伅
					for(int i=1;i<list.size();i++){
						//妫�鏌ユ槸鍚︾敱鍦板浘A杩涘叆鍦板浘B
						if(list.get(i).getMapId()==mapId2 &&list.get(i-1).getMapId()==mapId1){
							AcrossMap stats = new AcrossMap();
							stats.setApMac(res);
							stats.setEnterTime(list.get(i).getTime().toString());
							stats.setLeaveTime(list.get(i-1).getTime().toString());
							rs.add(stats); 
						}
					}
				}		
				return rs;	
			}
	//缁熻鏌愭鏃堕棿鍐呬粠鍦板浘A鍒板湴鍥綛鐨勪汉娆�
	public int getFromtoTimesCount(int enviromentId,int mapId1,int mapId2,
			String starttime,String endtime){
		List<AcrossMap> tagList = new ArrayList<AcrossMap>();
		tagList = this.getFromtotimesList(enviromentId,mapId1,mapId2,
				starttime,endtime);
		return tagList.size();
	}
	

	//缁熻鏌愭鏃堕棿鍐呬粠鍦板浘A鍒板湴鍥綛鐨勪汉鏁板垪琛�
	public List<AcrossMap> getAllTagInfoAcrossTwoMapsAtTimes(int environmentId,int mapId1,int mapId2,String starttime,String endtime){
		List<TagPos> list = new ArrayList<TagPos>();
		//鏌ヨ鏃堕棿娈靛唴鏇惧畾浣嶅湪鍦板浘B鐨勮澶囧垪琛�
		List<String> tagListReal = TagPosHelper.getMacListByTimeAndMap(environmentId, mapId2, starttime, endtime);
		List<AcrossMap> rs = new ArrayList<AcrossMap>();
		for(String res:tagListReal){
			list = TagPosHelper.getChosenTagListByTime(res, starttime, endtime);//鑾峰彇鍒楄〃涓殑涓�涓澶囧湪鏃堕棿娈靛唴鐨勬墍鏈変綅缃俊鎭�
			int count = 0; //鍒濆杩涘叆娆℃暟涓�0
			//閬嶅巻浣嶇疆淇℃伅
			for(int i=1;i<list.size();i++){
				//妫�鏌ユ槸鍚︾敱鍦板浘A杩涘叆鍦板浘B
				if(list.get(i).getMapId()==mapId2 &&list.get(i-1).getMapId()==mapId1){
					count++;//杩涘叆娆℃暟鍔�1
				}	
			}
			if(count>0){
				AcrossMap stats = new AcrossMap();
				stats.setApMac(res);
//				stats.setEnterTime();
//				stats.setLeaveTime();
				rs.add(stats);
			}
		}		
		return rs;	
	}

	//缁熻鏌愭鏃堕棿鍐呬粠鍦板浘A鍒板湴鍥綛鐨勪汉鏁�
	public int getNumbersOfAllTagAcrossTwoMapsAtTimes(int enviromentId,int mapId1,int mapId2,
			String datetimeStart,String datetimeEnd){
		List<AcrossMap> tagList = new ArrayList<AcrossMap>();
		tagList = this.getAllTagInfoAcrossTwoMapsAtTimes(enviromentId,mapId1,mapId2,
				datetimeStart,datetimeEnd);
		return tagList.size();
	}
	


		
}
