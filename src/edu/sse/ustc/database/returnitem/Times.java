package edu.sse.ustc.database.returnitem;

public class Times
{
    public String staMac;
    public String lastScanedTime;
    public String staVendor;
    public String staTimes;

    public String getStaMac()
    {
        return staMac;
    }

    public void setStaMac(String staMac)
    {
        this.staMac = staMac;
    }

    public String getLastScanedTime()
    {
        return lastScanedTime;
    }

    public void setLastScanedTime(String lastScanedTime)
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

    public String getStaTimes()
    {
        return staTimes;
    }

    public void setStaTimes(String staTimes)
    {
        this.staTimes = staTimes;
    }

    @Override
    public String toString()
    {
        return "Times [staMac=" + staMac + ", lastScanedTime=" + lastScanedTime + ", staVendor=" + staVendor + ", staTimes=" + staTimes + "]";
    }

}
