package edu.sse.ustc.database.stats;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.database.common.TagEnterTimes;
import edu.sse.ustc.database.common.TagLeaveTimes;
import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.innerclass.TagPos;

public class Times
{

    public List<TagEnterTimes> getEnteredList(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime,
            String endtime)
    {
        List<TagEnterTimes> rs = new ArrayList<TagEnterTimes>();
        List<TagPos> buffer = new ArrayList<TagPos>();
        
        List<String> tagList = new ArrayList<String>();
        buffer = TagPosHelper.getTagListByTime(enviromentId, mapId, starttime, endtime);
        System.out.println("size:"+buffer.size());
        for (TagPos res : buffer)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }
        List<String> tagListReal = removeDuplicateMac(tagList);
        System.out.println("realsize:"+tagListReal.size());
        List<TagPos> list = new ArrayList<TagPos>();
        for (String res : tagListReal)
        {
            list = TagPosHelper.getChosenTagListByTime(res, starttime, endtime);
            int count = 0;
            String lastTimeScanned = null;

            for (int i = 1; i < list.size(); i++)
            {	
            	if(list.get(i).getX_pos()!=0&&list.get(i).getY_pos()!=0)
            	{
            		if (this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && !this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4))
                    {
                        count++;
                        lastTimeScanned = list.get(i).getTime().toString();
                    }
            	}
            }
            if (count > 0)
            {
                TagEnterTimes stats = new TagEnterTimes();
                stats.setTagMac(res);
                stats.setBrand(Helper.getVendor(res));
                stats.setLastTimeScanned(lastTimeScanned);
                stats.setEnterTimes(count);
                rs.add(stats);
            }
        }
        return rs;
    }

    public int getEnteredCount(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
        List<TagEnterTimes> tagList = new ArrayList<TagEnterTimes>();
        tagList = this.getEnteredList(enviromentId, mapId, type, r1, r2, r3, r4, starttime, endtime);
        int times = 0;
        for (TagEnterTimes res : tagList)
        {
            times += res.getEnterTimes();
        }
        return times;
    }

    public List<TagLeaveTimes> getLeavedList(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime,
            String endtime)
    {
        List<TagLeaveTimes> rs = new ArrayList<TagLeaveTimes>();
        List<TagPos> list = new ArrayList<TagPos>();
        List<String> tagList = new ArrayList<String>();
        list = TagPosHelper.getTagListByTime(enviromentId, mapId, starttime, endtime);
        for (TagPos res : list)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }
        List<String> tagListReal = removeDuplicateMac(tagList);
        for (String res : tagListReal)
        {
            list = TagPosHelper.getChosenTagListByTime(res, starttime, endtime);
            int count = 0;
            String lastTimeScanned = null;
            for (int i = 1; i < list.size(); i++)
            {
            	if(list.get(i).getX_pos()!=0&&list.get(i).getY_pos()!=0)
            	{
            		if(!this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4))
                    {
                        count++;
                        lastTimeScanned = list.get(i).getTime().toString();
                    }
            	}
            }
            if (count > 0)
            {
                TagLeaveTimes stats = new TagLeaveTimes();
                // Tagcontent tagcontent = TagContentHelper.getTagByMac(res);
                stats.setTagMac(res);
                stats.setBrand(Helper.getVendor(res));                
                stats.setLastTimeScanned(lastTimeScanned);
                stats.setLeaveTimes(count);
                rs.add(stats);
            }
        }
        return rs;
    }

    public int getLeavedCount(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
        List<TagLeaveTimes> tagList = new ArrayList<TagLeaveTimes>();
        tagList = this.getLeavedList(enviromentId, mapId, type, r1, r2, r3, r4, starttime, endtime);
        int times = 0;
        for (TagLeaveTimes res : tagList)
        {
            times += res.getLeaveTimes();
        }
        return times;
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

    private List<String> removeDuplicateMac(List<String> rs)
    {
        HashSet h = new HashSet(rs);
        rs.clear();
        rs.addAll(h);
        return rs;
    }

}