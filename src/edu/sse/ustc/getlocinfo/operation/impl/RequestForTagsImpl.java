package edu.sse.ustc.getlocinfo.operation.impl;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;

import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.contract.ILocResultService;
import edu.sse.ustc.contract.InvalidOperation;
import edu.sse.ustc.contract.TagLocContract;
import edu.sse.ustc.contract.TagPathContract;
import edu.sse.ustc.getlocinfo.operation.RequestForTags;
import edu.sse.ustc.getlocinfo.services.ClassTranslator;
import edu.sse.ustc.getlocinfo.services.impl.ClassTranslatorImpl;
import edu.sse.ustc.innerclass.Tag;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;

public class RequestForTagsImpl implements RequestForTags {

	private ClassTranslator classTranslator = null;

	public RequestForTagsImpl() {
		classTranslator = new ClassTranslatorImpl();
	}

	@Override
	public List<TagPos> getTagCurLoc(List<byte[]> tagIdList, ILocResultService.Client client, Integer regID) {

		List<TagPos> tagLocContractList = new ArrayList<TagPos>();

		List<ByteBuffer> tagIdBuffer = new ArrayList<ByteBuffer>();

		for (int index = 0; index != tagIdList.size(); index++) {
			tagIdBuffer.set(index, ByteBuffer.wrap(tagIdList.get(index)));
		}
		try {
			tagLocContractList = classTranslator.getTagLocContractList(client.GetTagCurLoc(tagIdBuffer, (int) regID));
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return tagLocContractList;
	}

	@Override
	public List<TagPos> getMoveTagLoc(String startTime, List<byte[]> tagIdList,
			ILocResultService.Client client, Integer regID) {
		// TODO Auto-generated method stub
		if (regID == null) {
			// bu zhuo yi chang
		}

		List<TagPos> tagLocContractList = new ArrayList<TagPos>();

		List<ByteBuffer> tagIdBuffer = new ArrayList<ByteBuffer>();

		for (int index = 0; index != tagIdList.size(); index++) {
			tagIdBuffer.set(index, ByteBuffer.wrap(tagIdList.get(index)));
		}
		try {
			tagLocContractList = classTranslator.getTagLocContractList(client.GetMoveTagLoc(tagIdBuffer, (int) regID,
					startTime));
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return tagLocContractList;

	}

	@Override
	public List<TagPath> getTagCurPath(List<byte[]> tagIdList, ILocResultService.Client client, Integer regID) {
		// TODO Auto-generated method stub
		if (regID == null) {
			// bu zhuo yi chang
		}

		List<TagPath> tagPathContractList = new ArrayList<TagPath>();

		List<ByteBuffer> tagIdBuffer = new ArrayList<ByteBuffer>();

		for (int index = 0; index != tagIdList.size(); index++) {
			tagIdBuffer.set(index, ByteBuffer.wrap(tagIdList.get(index)));
		}
		try {
			tagPathContractList = classTranslator
					.getTagPathContractList(client.GetTagCurPath(tagIdBuffer, (int) regID));
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return tagPathContractList;
	}

	@Override
	public List<TagPath> getMoveTagPath(String startTime, List<byte[]> tagIdList, ILocResultService.Client client,
			Integer regID) {
		// TODO Auto-generated method stub

		List<TagPath> tagPathContractList = new ArrayList<TagPath>();

		List<ByteBuffer> tagIdBuffer = new ArrayList<ByteBuffer>();

		for (int index = 0; index != tagIdList.size(); index++) {
			tagIdBuffer.set(index, ByteBuffer.wrap(tagIdList.get(index)));
		}
		try {
			tagPathContractList = classTranslator.getTagPathContractList(client.GetMoveTagPath(tagIdBuffer,
					(int) regID, startTime));
		} catch (InvalidOperation e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return tagPathContractList;
	}

	@Override
	public List<Tag> getAllTag(ILocResultService.Client client, Integer regID) {

		List<Tag> tagContractList = new ArrayList<Tag>();

		try {
			tagContractList = classTranslator.getTagContractList(client.GetAllTag((int) regID));

		} catch (InvalidOperation e) {

			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		} catch (TException e) {

			MyLog.error(e.toString(), this.getClass().getName());
			//e.printStackTrace();
		}

		return tagContractList;
	}

}
