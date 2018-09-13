package edu.sse.ustc.database.save;

import java.util.List;

import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Environment;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.Tag;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;

/**
 * save object to database
 * @author fqbrighter
 *
 */
public interface SaveToDataBase {

	public boolean saveMap(Map mc);

	public boolean saveAP(AP apc);

	public boolean saveMapList(List<Map> lmc);

	public boolean saveAPList(List<AP> lapc);
	
	public boolean saveTagLocContract(TagPos tagLocContract);
	
	public boolean saveTagCurLoc(List<TagPos> tagLocContractList);
	
	public boolean saveMovTagLoc(List<TagPos> tagLocContractList);
	
	public boolean saveTagPathContract(TagPath tagPathContract);
	
	public boolean saveTagCurPath(List<TagPath> tagPathContractList);
	
	public boolean saveMoveTagPath(List<TagPath> tagPathContractList);
	
	public boolean saveAllTags(List<Tag> tagContractList);
	
	public boolean saveAllEnvironments(List<Environment> environmentList);
	
}
