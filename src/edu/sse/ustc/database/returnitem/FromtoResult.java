package edu.sse.ustc.database.returnitem;

import java.util.Date;

public class FromtoResult
{
    public String staMac;
    public Date leaveTime;
    public Date enterTime;

    public String getStaMac()
    {
        return staMac;
    }

    @Override
    public String toString()
    {
        return "FromtoResult [staMac=" + staMac + ", leaveTime=" + leaveTime + ", enterTime=" + enterTime + "]";
    }

    public void setStaMac(String staMac)
    {
        this.staMac = staMac;
    }

    public Date getLeaveTime()
    {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime)
    {
        this.leaveTime = leaveTime;
    }

    public Date getEnterTime()
    {
        return enterTime;
    }

    public void setEnterTime(Date enterTime)
    {
        this.enterTime = enterTime;
    }

}
