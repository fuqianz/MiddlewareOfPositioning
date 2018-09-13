package edu.sse.ustc.getlocinfo.services;

import java.util.List;

import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.LinkSegmentContent;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.PointContract;
import edu.sse.ustc.innerclass.RfidAPContract;
import edu.sse.ustc.innerclass.Tag;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;
import edu.sse.ustc.innerclass.myenum.APType;
import edu.sse.ustc.innerclass.myenum.CoordinateType;
import edu.sse.ustc.innerclass.myenum.DevStatus;
import edu.sse.ustc.innerclass.myenum.MapFormat;
import edu.sse.ustc.innerclass.myenum.MapType;
import edu.sse.ustc.innerclass.myenum.TagType;


public interface ClassTranslator
{

    public APType read(edu.sse.ustc.contract.APType art);

    public CoordinateType read(edu.sse.ustc.contract.CoordinateType cdt);

    public DevStatus read(edu.sse.ustc.contract.DevStatus ds);

    public MapFormat read(edu.sse.ustc.contract.MapFormat mf);

    public MapType read(edu.sse.ustc.contract.MapType mt);

    public TagType read(edu.sse.ustc.contract.TagType tt);

    public PointContract read(edu.sse.ustc.contract.PointContract pc);

    public List<PointContract> getPointContractList(List<edu.sse.ustc.contract.PointContract> verticeList);

    public LinkSegmentContent read(edu.sse.ustc.contract.LinkSegmentContract lsc);

    public List<LinkSegmentContent> getLinkSegmentContractList(List<edu.sse.ustc.contract.LinkSegmentContract> linkSegment);

    public Map read(edu.sse.ustc.contract.MapContract mc);

    public List<Map> getMapContractList(List<edu.sse.ustc.contract.MapContract> lmc);

    public Environment read(edu.sse.ustc.contract.EnvironmentContract ec);

    public List<Environment> getEnvironmentList(List<edu.sse.ustc.contract.EnvironmentContract> lec);

    public TagPos read(edu.sse.ustc.contract.TagLocContract tlc);

    public List<TagPos> getTagLocContractList(List<edu.sse.ustc.contract.TagLocContract> ltlc);

    public TagPath read(edu.sse.ustc.contract.TagPathContract tpc);

    public List<TagPath> getTagPathContractList(List<edu.sse.ustc.contract.TagPathContract> ltpc);

    public Tag read(edu.sse.ustc.contract.TagContract tc);

    public List<Tag> getTagContractList(List<edu.sse.ustc.contract.TagContract> ltc);

    public AP read(edu.sse.ustc.contract.APContract apc);

    public List<AP> getAPContractList(List<edu.sse.ustc.contract.APContract> lapc);

    public RfidAPContract read(edu.sse.ustc.contract.RfidApContract rfac);

}
