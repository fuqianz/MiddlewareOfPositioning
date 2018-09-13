package edu.sse.ustc.database.dao.helper;

import java.util.List;

import edu.sse.ustc.database.dao.TagContentDao;
import edu.sse.ustc.innerclass.Tag;
public class TagContentHelper {
	private static TagContentDao getTag = new TagContentDao();
	
	public static List<Tag> getTag(){
		return getTag.getTag();
	}

	public static List<byte[]> getTagId(){
		return getTag.getTagId();
	}
	
	public static Tag getTagByTagId(byte[] tagId) {
		return getTag.getTagByTagId(tagId);
	}
	
	public static Tag getTagByMac(String mac){
		return getTag.getTagByMac(mac);
	}
	
	public static boolean newTag(List<Tag> res){
		return getTag.newTag(res);
	}
	
//	public static void updateMap(byte[] tagId, String name, int tagType, String remark, boolean enable, String charageTime, String rate, String model, String mac) {
//		getTag.updateMap(tagId, name, tagType, remark, enable, charageTime, rate, model, mac);
//	}
 
	public static void delTags(byte[] tagId){
		getTag.delTags(tagId);
	}
}
