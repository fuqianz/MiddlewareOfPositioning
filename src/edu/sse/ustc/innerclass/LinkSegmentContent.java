package edu.sse.ustc.innerclass;

import java.util.List;

public class LinkSegmentContent
{
    private Integer id;
    private String name;
    private List<PointContract> verticesList;
    private Integer mapId;
    private String remark;
    private Integer linkedMapId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<PointContract> getVerticesList()
    {
        return verticesList;
    }

    public void setVerticesList(List<PointContract> verticesList)
    {
        this.verticesList = verticesList;
    }

    public Integer getMapId()
    {
        return mapId;
    }

    public void setMapId(Integer mapId)
    {
        this.mapId = mapId;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Integer getLinkedMapId()
    {
        return linkedMapId;
    }

    public void setLinkedMapId(Integer linkedMapId)
    {
        this.linkedMapId = linkedMapId;
    }

    @Override
    public String toString()
    {
        return "LinkSegmentContract [id=" + id + ", name=" + name + ", verticesList=" + verticesList + ", mapId=" + mapId + ", remark=" + remark
                + ", linkedMapId=" + linkedMapId + "]";
    }

}
