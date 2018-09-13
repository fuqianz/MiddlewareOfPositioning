package edu.sse.ustc.getlocinfo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.contract.APContract;
import edu.sse.ustc.getlocinfo.common.ByteArrayToImages;
import edu.sse.ustc.getlocinfo.common.TagIdToMac;
import edu.sse.ustc.getlocinfo.services.ClassTranslator;
import edu.sse.ustc.getlocinfo.services.ReadHelper;
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

public class ClassTranslatorImpl implements ClassTranslator {

	@Override
	public APType read(edu.sse.ustc.contract.APType art) {
		APType apType = APType.findByValue(art.toString());
		// System.out.println("Ap,ClassTranslatorImpl" + apType);
		return apType;
	}

	@Override
	public CoordinateType read(edu.sse.ustc.contract.CoordinateType cdt) {
		CoordinateType coordinateType = CoordinateType.findByValue(cdt.toString());
		// System.out.println("Coor,ClassTranslatorImpl" + coordinateType);
		return coordinateType;
	}

	@Override
	public DevStatus read(edu.sse.ustc.contract.DevStatus ds) {
		DevStatus devStatus = DevStatus.findByValue(ds.toString());
		// System.out.println("Dev,ClassTranslatorImpl" + devStatus);
		return devStatus;
	}

	@Override
	public MapFormat read(edu.sse.ustc.contract.MapFormat mf) {
		// System.out.println(mf.toString());
		MapFormat mapFormat = MapFormat.findByValue(mf.toString());
		// System.out.println("Map,ClassTranslatorImpl" + mapFormat);
		return mapFormat;
	}

	@Override
	public MapType read(edu.sse.ustc.contract.MapType mt) {
		MapType mapType = MapType.findByValue(mt.toString());
		// System.out.println("map,ClassTranslatorImpl" + mapType);
		return mapType;
	}

	@Override
	public TagType read(edu.sse.ustc.contract.TagType tt) {
		TagType tagType = TagType.findByValue(tt.toString());
		// System.out.println("tag,ClassTranslatorImpl" + tagType);
		return tagType;
	}

	@Override
	public PointContract read(edu.sse.ustc.contract.PointContract pc) {
		PointContract pointContract = new PointContract();
		pointContract.setMapId(pc.mapId);
		pointContract.setType(this.read(pc.type));
		pointContract.setX(pc.x);
		pointContract.setY(pc.y);
		pointContract.setZ(pc.z);
		// System.out.println("pc,ClassTranslatorImpl" + pointContract);
		return pointContract;
	}

	@Override
	public List<PointContract> getPointContractList(List<edu.sse.ustc.contract.PointContract> verticeList) {

		List<PointContract> lpc = new ArrayList<PointContract>();

		for (int index = 0; index != verticeList.size(); index++) {
			lpc.add(this.read(verticeList.get(index)));
		}
		// System.out.println("lpc,ClassTranslatorImpl" + lpc);
		return lpc;
	}

	@Override
	public LinkSegmentContent read(edu.sse.ustc.contract.LinkSegmentContract lsc) {
		LinkSegmentContent linkSegmentContract = new LinkSegmentContent();
		linkSegmentContract.setId(lsc.id);
		linkSegmentContract.setLinkedMapId(lsc.linkedMapId);
		linkSegmentContract.setMapId(lsc.mapId);
		linkSegmentContract.setName(lsc.name);
		linkSegmentContract.setRemark(lsc.remark);
		linkSegmentContract.setVerticesList(this.getPointContractList(lsc.verticesList));
		// System.out.println("lsc,ClassTranslatorImpl" + linkSegmentContract);
		return linkSegmentContract;
	}

	public List<LinkSegmentContent> getLinkSegmentContractList(
			List<edu.sse.ustc.contract.LinkSegmentContract> linkSegment) {
		List<LinkSegmentContent> lsc = new ArrayList<LinkSegmentContent>();

		for (int index = 0; index != linkSegment.size(); index++) {

			lsc.add(this.read(linkSegment.get(index)));
		}
		// System.out.println("llsc,ClassTranslatorImpl" + lsc);
		return lsc;
	}

	@Override
	public Map read(edu.sse.ustc.contract.MapContract mc) {

		Map mapContract = new Map();

		mapContract.setFatherMapId(mc.fatherMapId);
		mapContract.setHeight(mc.height);
		mapContract.setLinkSegment(this.getLinkSegmentContractList(mc.linkSegment));
		mapContract.setMapFormat(this.read(mc.mapFormat));
		mapContract.setMapId(mc.mapId);
		// mapContract.setMapImage(Convert.FromBase64String(mc.mapImage));
		mapContract.setMapImageName("img" + mc.mapId);
		mapContract.setMapSizeInByte(mc.mapSizeInByte);
		mapContract.setMaptype(this.read(mc.mapType));
		mapContract.setName(mc.name);
		mapContract.setRemark(mc.remark);
		mapContract.setScale(mc.scale);
		mapContract.setWidth(mc.width);
		mapContract.setEnvironmentId(mc.environmentId);
		mapContract.setMapURI("/environment/" + mc.environmentId + "/map/" + mc.mapId);
		// System.out.println("mc,ClassTranslatorImpl" + mapContract);
		ByteArrayToImages.transferAndSave(mc.mapImage, ByteArrayToImages.getMapFormatString(mc.mapFormat.getValue()),
				"img" + mc.mapId);
		return mapContract;
	}

	@Override
	public List<Map> getMapContractList(List<edu.sse.ustc.contract.MapContract> lmc) {

		List<Map> mapContractList = new ArrayList<Map>();

		for (int index = 0; index != lmc.size(); index++) {
			mapContractList.add(this.read(lmc.get(index)));
			// System.out.println(this.read(lmc.get(index)));
		}
		// System.out.println("lmc,ClassTranslatorImpl" + mapContractList);
		return mapContractList;
	}

	@Override
	public TagPos read(edu.sse.ustc.contract.TagLocContract tlc) {

		TagPos tagpos = new TagPos();
		tagpos.setEnvironmentId(ReadHelper.getEnvironmentId(tlc.pos.mapId));
		tagpos.setMapId(tlc.getPos().getMapId());
		tagpos.setSeqNum(-1);

		byte[] b = tlc.getTagId().getId();
		tagpos.setTagId(b);
		tagpos.setMac(TagIdToMac.transferMac(b));
		tagpos.setTime(Helper.stringToDate(tlc.getTime()));
		tagpos.setX_pos(tlc.getPos().getX());
		tagpos.setY_pos(tlc.getPos().getY());
		tagpos.setZ_pos(tlc.getPos().getZ());

		return tagpos;
	}

	@Override
	public List<TagPos> getTagLocContractList(List<edu.sse.ustc.contract.TagLocContract> ltlc) {
		List<TagPos> tagLocContractList = new ArrayList<TagPos>();

		for (int index = 0; index != ltlc.size(); index++) {
			tagLocContractList.add(this.read(ltlc.get(index)));
		}

		// System.out.println("ltlc,ClassTranslatorImpl" + tagLocContractList);
		return tagLocContractList;
	}

	@Override
	public TagPath read(edu.sse.ustc.contract.TagPathContract tpc) {
		TagPath tagPath = new TagPath();
		tagPath.setPath(this.getPointContractList(tpc.path));
		tagPath.setTagId(tpc.tagId.getId());
		tagPath.setTime(Helper.stringToDate(tpc.time));

		// System.out.println("tpc,ClassTranslatorImpl" + tagPathContract);
		return tagPath;
	}

	@Override
	public List<TagPath> getTagPathContractList(List<edu.sse.ustc.contract.TagPathContract> ltpc) {
		List<TagPath> tagPathContractList = new ArrayList<TagPath>();

		for (int index = 0; index != ltpc.size(); index++) {
			tagPathContractList.add(this.read(ltpc.get(index)));
		}

		// System.out.println("ltpc,ClassTranslatorImpl" + tagPathContractList);
		return tagPathContractList;
	}

	@Override
	public Tag read(edu.sse.ustc.contract.TagContract tc) {

		Tag tagContract = new Tag();
		tagContract.setCharageTime(tc.charageTime);
		tagContract.setEnable(tc.enable);
		tagContract.setMac(tc.mac);
		tagContract.setModel(tc.model);
		tagContract.setName(tc.name);
		tagContract.setRate(tc.rate);
		tagContract.setRemark(tc.remark);
		tagContract.setTagId(tc.tagId.getId());
		tagContract.setTagType(this.read(tc.tagType));

		// System.out.println("tc,ClassTranslatorImpl" + tagContract);
		return tagContract;
	}

	@Override
	public List<Tag> getTagContractList(List<edu.sse.ustc.contract.TagContract> ltc) {

		List<Tag> tagContractList = new ArrayList<Tag>();

		for (int index = 0; index != ltc.size(); index++) {
			tagContractList.add(this.read(ltc.get(index)));
		}

		// System.out.println("ltc,ClassTranslatorImpl" + tagContractList);
		return tagContractList;
	}

	@Override
	public AP read(edu.sse.ustc.contract.APContract apc) {

		AP apContract = new AP();

		apContract.setApType(this.read(apc.apType));
		apContract.setExtInfo(this.read(apc.extInfo));
		apContract.setApId(apc.id);
		apContract.setMapId(apc.pos.mapId);
		apContract.setEnvironmentId(ReadHelper.getEnvironmentId(apc.pos.mapId));
		apContract.setIp4Addr(apc.ip4Addr);
		apContract.setIp6Addr(apc.ip6Addr);
		apContract.setMac(apc.mac);
		apContract.setName(apc.name);
		apContract.setX_pos(apc.pos.x);
		apContract.setY_pos(apc.pos.y);
		apContract.setZ_pos(apc.pos.z);
		apContract.setProductModel(apc.productModel);
		apContract.setRemark(apc.remark);
		apContract.setStatus(this.read(apc.status));
		apContract.setApURI("/environment/"+apContract.getEnvironmentId()+"/map/"+apc.pos.mapId+"/ap/"+apc.mac);;
		// System.out.println("ac,ClassTranslatorImpl" + apContract);
		return apContract;
	}

	@Override
	public List<AP> getAPContractList(List<edu.sse.ustc.contract.APContract> lapc) {
		List<AP> apContractList = new ArrayList<AP>();

		for (int index = 0; index != lapc.size(); index++) {
			apContractList.add(this.read(lapc.get(index)));
			// System.out.println(this.read(lapc.get(index)));
		}

		// System.out.println("lac,ClassTranslatorImpl" + apContractList);
		return apContractList;
	}

	@Override
	public RfidAPContract read(edu.sse.ustc.contract.RfidApContract rfac) {
		// System.out.println("ClassTranslatorImpl" + rfac);
		return null;
	}

	@Override
	public Environment read(edu.sse.ustc.contract.EnvironmentContract ec) {
		// TODO Auto-generated method stub
		Environment env = new Environment();
		env.setEnvironmentId(ec.environmentId);
		env.setEnvironmentName(ec.environmentName);
		env.setEnvironmentURI("/environment/"+ec.environmentId);
		return env;
	}

	@Override
	public List<Environment> getEnvironmentList(List<edu.sse.ustc.contract.EnvironmentContract> lec) {
		// TODO Auto-generated method stub

		List<Environment> le = new ArrayList<Environment>();
		for (edu.sse.ustc.contract.EnvironmentContract ec : lec) {
			le.add(this.read(ec));
		}
		return le;
	}

}
