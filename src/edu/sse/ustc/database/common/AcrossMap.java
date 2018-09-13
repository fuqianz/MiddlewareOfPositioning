package edu.sse.ustc.database.common;

import java.util.Date;

public class AcrossMap {

	private String apMac;
	private String leaveTime;
	private String enterTime;

	public String getApMac() {
		return apMac;
	}

	public void setApMac(String apMac) {
		this.apMac = apMac;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	@Override
	public String toString() {
		return "AcrossMap [apMac=" + apMac + ", enterTime=" + enterTime + ", leaveTime=" + leaveTime + "]";
	}

}
