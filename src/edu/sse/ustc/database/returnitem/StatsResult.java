package edu.sse.ustc.database.returnitem;

import java.util.Date;

public class StatsResult
{
    public String staMac;
    public Date lastScanedTime;
    public String staVendor;

    public String getStaMac()
    {
        return staMac;
    }

    public void setStaMac(String staMac)
    {
        this.staMac = staMac;
    }

    @Override
    public String toString()
    {
        return "StatsResult [staMac=" + staMac + ", lastScanedTime=" + lastScanedTime + ", staVendor=" + staVendor + "]";
    }

    public Date getLastScanedTime()
    {
        return lastScanedTime;
    }

    public void setLastScanedTime(Date lastScanedTime)
    {
        this.lastScanedTime = lastScanedTime;
    }

    public String getStaVendor()
    {
        return staVendor;
    }

    public void setStaVendor(String staVendor)
    {
        this.staVendor = staVendor;
    }

}
