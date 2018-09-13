package edu.sse.ustc.getlocinfo.operation;

import java.util.List;

import edu.sse.ustc.contract.ILocResultService;
import edu.sse.ustc.innerclass.Tag;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;

public interface RequestForTags {

	List<Tag> getAllTag(ILocResultService.Client client, Integer regID);

	List<TagPos> getTagCurLoc(List<byte[]> tagIdList, ILocResultService.Client client, Integer regID);

	List<TagPos> getMoveTagLoc(String startTime, List<byte[]> tagIdList, ILocResultService.Client client, Integer regID);

	List<TagPath> getTagCurPath(List<byte[]> tagIdList, ILocResultService.Client client, Integer regID);

	List<TagPath> getMoveTagPath(String startTime, List<byte[]> tagIdList, ILocResultService.Client client,
			Integer regID);
}
