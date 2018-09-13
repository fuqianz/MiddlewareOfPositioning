package edu.sse.ustc.database.common;

public class StayInfo {
	
	private double averageStayTime;
	private double stayTimeVar;
	public double getAverageStayTime() {
		return averageStayTime;
	}
	public void setAverageStayTime(double averageStayTime) {
		this.averageStayTime = averageStayTime;
	}
	public double getStayTimeVar() {
		return stayTimeVar;
	}
	public void setStayTimeVar(double stayTimeVar) {
		this.stayTimeVar = stayTimeVar;
	}
	@Override
	public String toString() {
		return "StayInfo [averageStayTime=" + averageStayTime + ", stayTimeVar=" + stayTimeVar + "]";
	}

}
