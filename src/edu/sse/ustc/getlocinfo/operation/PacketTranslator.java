package edu.sse.ustc.getlocinfo.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import edu.sse.ustc.common.Helper;
import edu.sse.ustc.common.MyLog;
import edu.sse.ustc.getlocinfo.common.FormatTransfer;
import edu.sse.ustc.innerclass.PointContract;
import edu.sse.ustc.innerclass.TagPath;
import edu.sse.ustc.innerclass.TagPos;
import edu.sse.ustc.innerclass.myenum.CoordinateType;

/**
 * translator the information included in the datagram from server
 * 
 * @author fqbrighter
 *
 */
public class PacketTranslator {

	private final static short targetPositionInfoLen = 32;

	/**
	 * translator the target's position packet from server
	 * 
	 * @param tposinfo
	 * @return
	 */
	public static TagPos targetPositionInfo(byte[] tposinfo) {
		
		TagPos tagLocContract = new TagPos();
		int offset = 2;
    	short msgLen = FormatTransfer.hBytesToShort(tposinfo, offset, 2);
    	
        //System.out.println(msgLen);
        
		if (msgLen != targetPositionInfoLen) {
			// packet error
			//System.out.println("Packet error 1");
			MyLog.error("SOCKET PACKET LENGTH ERROR!", "edu.sse.ustc.getlocinfo.operation.PacketTranslator");
			return null;
		}

		// get timeStamp
		offset += 2;
		String timeStamp = FormatTransfer.bytesToTime(tposinfo, offset, 8);

		tagLocContract.setTime(Helper.stringToDate(timeStamp));//timeStamp.toString());

		offset += 8;
		// get TagId
		//TagIdContract tagID = new TagIdContract();
		byte[] id = new byte[8];
		
		System.arraycopy(tposinfo, offset, id, id.length, 8);
		
		tagLocContract.setTagId(id);


		offset += 8;
		int mapId = FormatTransfer.hBytesToInt(tposinfo, offset, 4);

		// get x
		offset += 4;
		int x = FormatTransfer.hBytesToInt(tposinfo, offset, 4);
		// get y
		offset += 4;
		int y = FormatTransfer.hBytesToInt(tposinfo, offset, 4);
		// get z
		offset += 4;
		int z = FormatTransfer.hBytesToInt(tposinfo, offset, 4);
		offset += 4;

		tagLocContract.setMapId(mapId);
		tagLocContract.setX_pos(x);
		tagLocContract.setY_pos(y);

		/**
		 * z is not used
		 */
		tagLocContract.setZ_pos(z);
		return tagLocContract;
	}

	/**
	 * {translator the target's path packet from server
	 * 
	 * @param tpathinfo
	 * @return
	 */
	public static TagPath targetPathInfo(byte[] tpathinfo) {

		//System.out.println(tpathinfo);
		//FormatTransfer.printBytes(tpathinfo);
		TagPath tagPathContract = new TagPath();

		int offset = 2;
		short msgLen = FormatTransfer.hBytesToShort(tpathinfo, offset, 2);
        //System.out.println(msgLen);
		// get timeStamp
 		offset += 2;
		String timeStamp = FormatTransfer.bytesToTime(tpathinfo, offset, 8);

		tagPathContract.setTime(Helper.stringToDate(timeStamp));
		
		offset += 8;
		// get TagId
		//TagIdContract tagID = new TagIdContract();
		byte[] id = new byte[8];
		System.arraycopy(tpathinfo, offset, id, 0, id.length);
		tagPathContract.setTagId(id);

		offset += 8;
		short nodeNum = FormatTransfer.hBytesToShort(tpathinfo, offset, 2);

		List<PointContract> ltpc = new ArrayList<PointContract>();

		offset += 2;

		while (nodeNum > 0) {

			PointContract pc = new PointContract();
			// getmapId
			int mapId = FormatTransfer.hBytesToInt(tpathinfo, offset, 4);

			// get x
			offset += 4;
			int x = FormatTransfer.hBytesToInt(tpathinfo, offset, 4);

			offset += 4;
			int y = FormatTransfer.hBytesToInt(tpathinfo, offset, 4);
			// get z
			offset += 4;
			int z =FormatTransfer.hBytesToInt(tpathinfo, offset, 4);
			offset += 4;
			pc.setMapId(mapId);
			pc.setType(CoordinateType.RCTANGULAR);
			pc.setX(x);
			pc.setY(y);
			pc.setZ(z);
			ltpc.add(pc);

			nodeNum--;
		}

		tagPathContract.setPath(ltpc);
		
		return tagPathContract;
	}

	/**
	 * {translator device status change event from server}
	 * 
	 * @param dcinfo
	 * @return
	 */
	public static boolean deviceStatusChangeEvent(byte[] dcinfo) {
		boolean flag = true;
		return flag;
	}

	/**
	 * {translator tag call event from server}
	 * 
	 * @param tce
	 * @return
	 */
	public static boolean tagCallEvent(byte[] tce) {
		boolean flag = true;
		return flag;
	}

	/**
	 * {translator tag low power event}
	 * 
	 * @param tlpe
	 * @return
	 */
	public static boolean tagLowPowerEvent(byte[] tlpe) {
		boolean flag = true;
		return flag;
	}

}
