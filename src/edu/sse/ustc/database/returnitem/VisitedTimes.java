package edu.sse.ustc.database.returnitem;

import java.util.List;

public class VisitedTimes {
	private int totalcustomers_count;
	private List<edu.sse.ustc.database.returnitem.Totalcustomers> totalcustomers_list;
	public int getTotalcustomers_count() {
		return totalcustomers_count;
	}
	public void setTotalcustomers_count(int totalcustomers_count) {
		this.totalcustomers_count = totalcustomers_count;
	}
	public List<edu.sse.ustc.database.returnitem.Totalcustomers> getTotalcustomers_list() {
		return totalcustomers_list;
	}
	public void setTotalcustomers_list(
			List<edu.sse.ustc.database.returnitem.Totalcustomers> totalcustomers_list) {
		this.totalcustomers_list = totalcustomers_list;
	}
	
	

}
