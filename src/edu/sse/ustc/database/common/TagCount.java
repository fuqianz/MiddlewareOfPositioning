package edu.sse.ustc.database.common;

public class TagCount {
	public String staMac;
	public String lastScanedTime;
	public String staVendor;
	public String getStaMac() {
		return staMac;
	}
	public void setStaMac(String staMac) {
		this.staMac = staMac;
	}
	public String getLastScanedTime() {
		return lastScanedTime;
	}
	public void setLastScanedTime(String lastScanedTime) {
		this.lastScanedTime = lastScanedTime;
	}
	public String getStaVendor() {
		return staVendor;
	}
	public void setStaVendor(String staVendor) {
		this.staVendor = staVendor;
	}
	@Override
	public String toString() {
		return "TagCount [staMac=" + staMac + ", lastScanedTime=" + lastScanedTime + ",staVendor="+staVendor+"]";
	}
	

}
