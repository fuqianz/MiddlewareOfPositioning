package edu.sse.ustc.database.common;

import java.util.Date;

public class TagLeaveTimes {
	private String tagMac;
	private String lastTimeScanned;
	private String brand;
	private int leaveTimes;

	public String getTagMac() {
		return tagMac;
	}

	public void setTagMac(String tagMac) {
		this.tagMac = tagMac;
	}

	public String getLastTimeScanned() {
		return lastTimeScanned;
	}

	public void setLastTimeScanned(String lastTimeScanned) {
		this.lastTimeScanned = lastTimeScanned;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getLeaveTimes() {
		return leaveTimes;
	}

	public void setLeaveTimes(int leaveTimes) {
		this.leaveTimes = leaveTimes;
	}

	@Override
	public String toString() {
		return "TagLeaveTimes [tagMac=" + tagMac + ", lastTimeScanned=" + lastTimeScanned + ", brand=" + brand + ", leaveTimes=" + leaveTimes + "]";
	}

}
