   package edu.sse.ustc.database.returnitem;

import java.util.List;

public class Totalcustomers {

	private String sta_mac;
	private int visited_time;
	private List<edu.sse.ustc.database.returnitem.VisitedRecords> visited_records;
	public String getSta_mac() {
		return sta_mac;
	}
	public void setSta_mac(String sta_mac) {
		this.sta_mac = sta_mac;
	}
	public int getVisited_time() {
		return visited_time;
	}
	public void setVisited_time(int visited_time) {
		this.visited_time = visited_time;
	}
	public List<edu.sse.ustc.database.returnitem.VisitedRecords> getVisited_records() {
		return visited_records;
	}
	public void setVisited_records(
			List<edu.sse.ustc.database.returnitem.VisitedRecords> visited_records) {
		this.visited_records = visited_records;
	}
}
