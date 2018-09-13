package edu.sse.ustc.database.returnitem;

import java.util.List;

public class Customers {

	private int oldcustomers_count;
	private List<CustomerInfo> oldcustomers_list;
	private int newcustomers_count;
	private List<CustomerInfo> newcustomers_list;
	public int getOldcustomers_count() {
		return oldcustomers_count;
	}
	public void setOldcustomers_count(int oldcustomers_count) {
		this.oldcustomers_count = oldcustomers_count;
	}
	public List<CustomerInfo> getOldcustomers_list() {
		return oldcustomers_list;
	}
	public void setOldcustomers_list(List<CustomerInfo> oldcustomers_list) {
		this.oldcustomers_list = oldcustomers_list;
	}
	public int getNewcustomers_count() {
		return newcustomers_count;
	}
	public void setNewcustomers_count(int newcustomers_count) {
		this.newcustomers_count = newcustomers_count;
	}
	public List<CustomerInfo> getNewcustomers_list() {
		return newcustomers_list;
	}
	public void setNewcustomers_list(List<CustomerInfo> newcustomers_list) {
		this.newcustomers_list = newcustomers_list;
	}
}
