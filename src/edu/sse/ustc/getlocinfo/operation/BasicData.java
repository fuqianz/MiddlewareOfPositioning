package edu.sse.ustc.getlocinfo.operation;

import java.util.List;

import edu.sse.ustc.innerclass.AP;
import edu.sse.ustc.innerclass.Map;
import edu.sse.ustc.innerclass.Tag;

/**
 * 
 * get basic data from server
 * 
 * @author fqbrighter
 *
 */
public interface BasicData {

	List<Tag> getAllTag(ConnectOperation clientConnect);

	List<Map> getMaps(List<Integer> mapIDList, ConnectOperation clientConnect);

	List<AP> getAPs(Integer mapID, List<String> apMac, ConnectOperation clientConnect);

}
