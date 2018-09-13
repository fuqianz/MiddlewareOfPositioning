package edu.sse.ustc.database.stats;

import java.util.ArrayList;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.database.realtime.GetRealTimeTags;
import edu.sse.ustc.database.returnitem.Stas;
import edu.sse.ustc.innerclass.TagPos;
import edu.sse.ustc.database.stats.Times;
public class Stats
{

    // 缁熻鏌愭鏃堕棿杩涘叆浜嗘煇涓尯鍩熺殑鍒楄〃
    public List<Stas> getEnteredList(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime,
            String endtime)
    {
        List<Stas> rs = new ArrayList<Stas>();
        List<TagPos> list = new ArrayList<TagPos>();
        List<String> tagList = new ArrayList<String>();
        // 鑾峰彇缁撴潫鏃跺埢鐨勪綅缃�
        list = TagPosHelper.getPosListByTimeAndMap(enviromentId, mapId, endtime);
        // 鍘婚櫎缁撴潫鏃跺埢涓嶅湪鍖哄煙鍐呯殑璁惧
        for (TagPos res : list)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }int i = 0;
        for (String res : tagList)
        {

            TagPos tagStart = TagPosHelper.getPosListByMacAndChosenTime(res, starttime);

            TagPos tagEnd = TagPosHelper.getPosListByMacAndChosenTime(res, endtime);
            if(tagStart!=null&&tagEnd!=null)
            {
            	if (!this.isIn(tagStart, mapId, type, r1, r2, r3, r4) && this.isIn(tagEnd, mapId, type, r1, r2, r3, r4))
                {
                	Stas tag = new Stas();
                    tag.setSta_mac(res);
//                    tag.setLast_scaned_time(new GetRealTimeTags().getTagScannedInMapPos(enviromentId, mapId, res).getDatetime());
//                    tag.setSta_vendor(Helper.getVendor(res));
                    rs.add(tag);System.out.println(i++);
                }
            }
            
        }

        return rs;
    }

    public int getEnteredCount(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
    	
        return new Times().getEnteredList(enviromentId, mapId, type, r1, r2, r3, r4, starttime, endtime).size();
    }

    public List<Stas> getLeavedList(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime,
            String endtime)
    {
        List<Stas> rs = new ArrayList<Stas>();
        List<TagPos> list = new ArrayList<TagPos>();
        List<String> tagList = new ArrayList<String>();
        // 鑾峰彇寮�濮嬫椂鍒荤殑浣嶇疆
        list = TagPosHelper.getPosListByTimeAndMap(enviromentId, mapId, starttime);
        // 鍘婚櫎寮�濮嬫椂鍒讳笉鍦ㄥ尯鍩熷唴鐨勮澶�
        for (TagPos res : list)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }
        for (String res : tagList)
        {

            TagPos tagStart = TagPosHelper.getPosListByMacAndChosenTime(res, starttime);

            TagPos tagEnd = TagPosHelper.getPosListByMacAndChosenTime(res, endtime);
            if(tagStart!=null&&tagEnd!=null)
            {
            	if (this.isIn(tagStart, mapId, type, r1, r2, r3, r4) && !this.isIn(tagEnd, mapId, type, r1, r2, r3, r4))
                {
                	Stas tag = new Stas();
                    tag.setSta_mac(res);
//                    tag.setLast_scaned_time(new GetRealTimeTags().getTagScannedInMapPos(enviromentId, mapId, res).getDatetime());
//                    tag.setSta_vendor(Helper.getVendor(res));                
                    rs.add(tag);
                }
            }
            
        }
        return rs;
    }

    public int getLeavedCount(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
        return new Times().getLeavedList(enviromentId, mapId, type, r1, r2, r3, r4, starttime, endtime).size();

    }

    private boolean isIn(TagPos tag, int mapId, int type, double r1, double r2, double r3, double r4)
    {
        if (type == 0)
        {
            if (tag.getMapId() == mapId) return true;
            else
                return false;
        }
        else if (type == 1)
        {
            if (r1 <= tag.getX_pos() && r3 >= tag.getX_pos() && r2 <= tag.getY_pos() && r4 >= tag.getY_pos() && tag.getMapId() == mapId) return true;
            else
                return false;
        }
        else if (type == 2)
        {
            if (((Math.pow((r1 - tag.getX_pos()), 2) + Math.pow((r2 - tag.getY_pos()), 2)) <= Math.pow(r3, 2)) && tag.getMapId() == mapId) return true;
            else
                return false;
        }
        else
            return false;
    }

}
