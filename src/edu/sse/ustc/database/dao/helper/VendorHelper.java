package edu.sse.ustc.database.dao.helper;

import java.util.List;

import edu.sse.ustc.database.dao.VendorDao;
import edu.sse.ustc.innerclass.Vendor;

public  class VendorHelper {
	private static VendorDao getVendor = new VendorDao();
	
	public static String getVendor(String mac){
		return getVendor.getVendor(mac);
	}
	
	public static boolean newVendor(List<Vendor> vendors){
		return getVendor.newVendor(vendors);
	}
}
