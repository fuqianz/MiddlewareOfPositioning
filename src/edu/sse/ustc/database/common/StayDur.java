package edu.sse.ustc.database.common;

public class StayDur {

	private Integer mapid;
	private double stayTime;

	public Integer getMapid() {
		return mapid;
	}

	public void setMapid(Integer mapid) {
		this.mapid = mapid;
	}

	public double getStayTime() {
		return stayTime;
	}

	public void setStayTime(double d) {
		this.stayTime = d;
	}

	@Override
	public String toString() {
		return "StayDur [mapid=" + mapid + ", stayTime=" + stayTime + "]";
	}
}
