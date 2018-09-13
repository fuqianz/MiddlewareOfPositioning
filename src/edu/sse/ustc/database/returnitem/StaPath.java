package edu.sse.ustc.database.returnitem;

import java.util.Date;

public class StaPath
{
    private Integer seq_num;
    private Integer environment_id;
    private Integer map_id;
    private Integer pos_x;
    private Integer pos_y;
    private Integer pos_z;
    private Date datetime;

    public Integer getSeq_num()
    {
        return seq_num;
    }

    @Override
    public String toString()
    {
        return "StaPath [seq_num=" + seq_num + ", environment_id=" + environment_id + ", map_id=" + map_id + ", pos_x=" + pos_x + ", pos_y=" + pos_y
                + ", pos_z=" + pos_z + ", datetime=" + datetime + "]";
    }

    public void setSeq_num(Integer seqNum)
    {
        seq_num = seqNum;
    }

    public Integer getEnvironment_id()
    {
        return environment_id;
    }

    public void setEnvironment_id(Integer environmentId)
    {
        environment_id = environmentId;
    }

    public Integer getMap_id()
    {
        return map_id;
    }

    public void setMap_id(Integer mapId)
    {
        map_id = mapId;
    }

    public Integer getPos_x()
    {
        return pos_x;
    }

    public void setPos_x(Integer posX)
    {
        pos_x = posX;
    }

    public Integer getPos_y()
    {
        return pos_y;
    }

    public void setPos_y(Integer posY)
    {
        pos_y = posY;
    }

    public Integer getPos_z()
    {
        return pos_z;
    }

    public void setPos_z(Integer posZ)
    {
        pos_z = posZ;
    }

    public Date getDatetime()
    {
        return datetime;
    }

    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
    }

}
