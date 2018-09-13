package edu.sse.ustc.database.common;

import java.util.Date;

public class TagEnterTimes
{

    private String tagMac;
    private String lastTimeScanned;
    private String brand;
    private int enterTimes;

    public String getTagMac()
    {
        return tagMac;
    }

    public void setTagMac(String tagMac)
    {
        this.tagMac = tagMac;
    }

    public String getLastTimeScanned()
    {
        return lastTimeScanned;
    }

    public void setLastTimeScanned(String lastTimeScanned)
    {
        this.lastTimeScanned = lastTimeScanned;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public int getEnterTimes()
    {
        return enterTimes;
    }

    public void setEnterTimes(int enterTimes)
    {
        this.enterTimes = enterTimes;
    }

    @Override
    public String toString()
    {
        return "TagEnterTimes [tagMac=" + tagMac + ", lastTimeScanned=" + lastTimeScanned + ", brand=" + brand + ", enterTimes=" + enterTimes + "]";
    }

}
