package edu.sse.ustc.innerclass;

import edu.sse.ustc.innerclass.myenum.CoordinateType;


public class PointContract
{
    private Integer mapId;
    private CoordinateType type;
    private Integer x;
    private Integer y;
    private Integer z;

    public Integer getMapId()
    {
        return mapId;
    }

    public void setMapId(Integer mapId)
    {
        this.mapId = mapId;
    }

    public CoordinateType getType()
    {
        return type;
    }

    public void setType(CoordinateType type)
    {
        this.type = type;
    }

    public Integer getX()
    {
        return x;
    }

    public void setX(Integer x)
    {
        this.x = x;
    }

    public Integer getY()
    {
        return y;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }

    public Integer getZ()
    {
        return z;
    }

    public void setZ(Integer z)
    {
        this.z = z;
    }

    @Override
    public String toString()
    {
        return "PointContract [mapId=" + mapId + ", type=" + type + ", x=" + x + ", y=" + y + ", z=" + z + "]";
    }

}
