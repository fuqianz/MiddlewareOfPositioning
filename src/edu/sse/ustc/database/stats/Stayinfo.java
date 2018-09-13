package edu.sse.ustc.database.stats;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.text.DecimalFormat;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.database.dao.helper.TagPosHelper;
import edu.sse.ustc.innerclass.TagPos;


public class Stayinfo
{
    public double getStayduration(int enviromentId, String mac, int mapId, int type, double r1, double r2, double r3, double r4, String starttime,
            String endtime)
    {
        List<TagPos> list = new ArrayList<TagPos>();
        list = TagPosHelper.getChosenTagListByTime(mac, starttime, endtime);
        int flag = 0;
        double sum = 0;
        Date lastComeIn = null;

        for (int i = 1; i < list.size(); i++)
        {

            // System.out.println("last:" + list.get(i - 1).getPointY());
            // System.out.println("now:" + list.get(i).getPointY());
            // System.out.println(flag);
        	//从未进入状态到进入状态时
            if (this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && !this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4) && flag == 0)
            {
                flag = 1;
                lastComeIn = list.get(i).getTime();
                // System.out.println("in");
            }
            //从进入状态到未进入状态时
            else if (!this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4) && flag == 1)
            {
                flag = 0;
                sum += (list.get(i).getTime()).getTime() - lastComeIn.getTime();
                lastComeIn = null;
                // System.out.println("out");
            }
            //一开始就在区域内后仍在区域内
            else if (this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4) && this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && flag == 0)
            {
                lastComeIn = list.get(i - 1).getTime();
                flag = 1;
                // System.out.println("in0");
            }
            //从一开始就在区域内的状态离开区域时
            else if (this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4) && !this.isIn(list.get(i), mapId, type, r1, r2, r3, r4) && flag == 0)
            {
                lastComeIn = list.get(i - 1).getTime();
                flag = 0;
                sum += (list.get(i).getTime()).getTime() - lastComeIn.getTime();
                // System.out.println("in0");
            }
            //在统计时间结束时仍在区域内
            else if (this.isIn(list.get(i - 1), mapId, type, r1, r2, r3, r4) && this.isIn(list.get(i), mapId, type, r1, r2, r3, r4)
                    && i == (list.size() - 1))
            {
                sum += (list.get(i).getTime()).getTime() - lastComeIn.getTime();
                // System.out.println("out0");
            }

        }
        return sum;
    }

    public double getStayave(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
        double result = 0;
        List<TagPos> list = new ArrayList<TagPos>();
        List<String> tagList = new ArrayList<String>();
        list = TagPosHelper.getTagListByTime(enviromentId, mapId, starttime, endtime);
        for (TagPos res : list)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }
        if (tagList.isEmpty()) return 0;
        List<String> tagListReal = removeDuplicateMac(tagList);
        for (String res : tagListReal)
        {
            double sum = 0;
            sum = this.getStayduration(enviromentId, res, mapId, type, r1, r2, r3, r4, starttime, endtime);
//            System.out.println("item:"+sum+"mac:"+res);
            result += sum;
        }
        return result / tagListReal.size();
    }

    public double getStayvar(int enviromentId, int mapId, int type, double r1, double r2, double r3, double r4, String starttime, String endtime)
    {
        double result = 0;
        List<TagPos> list = new ArrayList<TagPos>();
        List<String> tagList = new ArrayList<String>();
        list = TagPosHelper.getTagListByTime(enviromentId, mapId, starttime, endtime);
        for (TagPos res : list)
        {
            if (this.isIn(res, mapId, type, r1, r2, r3, r4)) tagList.add(res.getMac());
        }
        if (tagList.isEmpty()) return 0;
        List<String> tagListReal = removeDuplicateMac(tagList);
        double ave = getStayave(enviromentId, mapId, type, r1, r2, r3, r4, starttime, endtime);
        for (int i = 0; i < tagListReal.size() - 1; i++)
        {
            double item = getStayduration(enviromentId, tagListReal.get(i), mapId, type, r1, r2, r3, r4, starttime, endtime);
            result += ((item - ave) * (item - ave));
        }
        
//        System.out.println("ave:"+ave);
        return result / tagListReal.size();
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
            if (r1 <= tag.getX_pos() && r3 >= tag.getX_pos()&& r2 <= tag.getY_pos() && r4 >= tag.getY_pos() && tag.getMapId() == mapId) return true;
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