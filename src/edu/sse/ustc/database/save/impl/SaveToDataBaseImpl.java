package edu.sse.ustc.database.save.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.database.dao.ApContentDao;
import edu.sse.ustc.database.dao.EnvironmentDao;
import edu.sse.ustc.database.dao.MapDao;
import edu.sse.ustc.database.dao.TagContentDao;
import edu.sse.ustc.database.dao.TagPosDao;
import edu.sse.ustc.database.save.SaveToDataBase;
import edu.sse.ustc.getlocinfo.services.ReadHelper;
import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.PointContract;
import edu.sse.ustc.innerclass.Tag;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;

public class SaveToDataBaseImpl implements SaveToDataBase {

	@Override
	public boolean saveMap(Map mc) {
		// TODO Auto-generated method stub
		return new MapDao().newMap(mc);
	}

	@Override
	public boolean saveAP(AP apc) {
		// TODO Auto-generated method stub
		return new ApContentDao().newAp(apc);
	}

	@Override
	public boolean saveMapList(List<Map> lmc) {
		// TODO Auto-generated method stub
		return new MapDao().newMap(lmc);
	}

	@Override
	public boolean saveAPList(List<AP> lapc) {
		// TODO Auto-generated method stub

		return new ApContentDao().newAp(lapc);
	}

	@Override
	public boolean saveTagLocContract(TagPos tagLocContract) {
		// TODO Auto-generated method stub
		// List<TagPos> list = new ArrayList<TagPos>();
		// list.add(tagLocContract);
		return new TagPosDao().newTagPos(tagLocContract);
	}

	@Override
	public boolean saveTagCurLoc(List<TagPos> tagLocContractList) {
		// TODO Auto-generated method stub
		return new TagPosDao().newTagPos(tagLocContractList);
	}

	@Override
	public boolean saveMovTagLoc(List<TagPos> list) {
		// TODO Auto-generated method stub
		return new TagPosDao().newTagPos(list);
	}

	@Override
	public boolean saveTagPathContract(TagPath tagPathContract) {
		// TODO Auto-generated method stub
		// System.out.println(tagPathContract);
		return new TagPosDao().newTagPos(this.read(tagPathContract));
	}

	@Override
	public boolean saveTagCurPath(List<TagPath> tagPathContractList) {
		// TODO Auto-generated method stub
		List<TagPos> path = new ArrayList<TagPos>();
		for (TagPath pa : tagPathContractList) {

			path.addAll(this.read(pa));
		}

		return new TagPosDao().newTagPos(path);
	}

	@Override
	public boolean saveMoveTagPath(List<TagPath> tagPathContractList) {

		List<TagPos> path = new ArrayList<TagPos>();
		for (TagPath pa : tagPathContractList) {

			path.addAll(this.read(pa));
		}

		return new TagPosDao().newTagPos(path);
	}

	@Override
	public boolean saveAllTags(List<Tag> list) {
		// TODO Auto-generated method stub
		return new TagContentDao().newTag(list);
	}

	@Override
	public boolean saveAllEnvironments(List<Environment> environmentList) {
		// TODO Auto-generated method stub
		return new EnvironmentDao().newEnvironment(environmentList);
	}

	private List<TagPos> read(TagPath tag) {
		List<TagPos> list = new ArrayList<TagPos>();
		List<PointContract> pos = tag.getPath();

		byte[] tagId = tag.getTagId();
		String mac = Helper.BytesToHexString(Arrays.copyOfRange(tagId, 2, tagId.length));
		int i = 0;
		for (PointContract point : pos) {
			TagPos tagpos = new TagPos();
			tagpos.setMapId(point.getMapId());
			tagpos.setSeqNum(i);
			i++;
			tagpos.setX_pos(point.getX());
			tagpos.setY_pos(point.getY());
			tagpos.setZ_pos(point.getZ());
			tagpos.setTagId(tagId);
			tagpos.setMac(mac);
			tagpos.setTime(tag.getTime());
			tagpos.setEnvironmentId(ReadHelper.getEnvironmentId(point.getMapId()));
			list.add(tagpos);

		}
		// System.out.println(list.toString());
		return list;
	}

}
