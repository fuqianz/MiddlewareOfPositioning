package edu.sse.ustc.database.returnitem;

import java.util.List;

public class StasPath
{
    private String sta_mac;
    private List<StaPath> sta_path;

    public String getSta_mac()
    {
        return sta_mac;
    }

    public void setSta_mac(String staMac)
    {
        sta_mac = staMac;
    }

    @Override
    public String toString()
    {
        return "StasPath [sta_mac=" + sta_mac + ", sta_path=" + sta_path + "]";
    }

    public List<StaPath> getSta_path()
    {
        return sta_path;
    }

    public void setSta_path(List<StaPath> staPath)
    {
        sta_path = staPath;
    }

}
