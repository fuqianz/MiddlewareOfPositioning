package edu.sse.ustc.database.dao.helper;
import java.util.List;

import edu.sse.ustc.database.dao.ApContentDao;
import edu.sse.ustc.innerclass.AP;

public class ApContentHelper {
	private static ApContentDao getAp = new ApContentDao();
	
	public static List<AP> getAp(){
		return getAp.getAp();
	}
	public static List<Integer> getApId(){
		return getAp.getApId();
	}
	public static AP getApByApId(int apId){
		return getAp.getApByApId(apId);
	}
	
	public static List<AP> getAp(int environmentId, int mapId){
		return getAp.getAp(environmentId, mapId);
	}
	public static AP getApByApMac(int environmentId, int mapId,String apMac){
		return getAp.getApByApMac(environmentId, mapId, apMac);
	}
	public static boolean newAp(List<AP> res){
		return getAp.newAp(res);
	}
//	public static void updateAp(int apId, String apName,String mac,int status,String productModel,
//			String ipv4Addr,String ipv6Addr,String remark,int apType,String extInfo,int pointTypeNow,int xnow,
//			int ynow,int znow){
//		getAp.updateAp(apId, apName, mac, status, productModel, ipv4Addr, ipv6Addr, remark, apType, extInfo, pointTypeNow, xnow, ynow, znow);
//	}
	public static void delAp(int apId){
		getAp.delAp(apId);
	}
}
