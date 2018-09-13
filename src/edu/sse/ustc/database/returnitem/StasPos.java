package edu.sse.ustc.database.returnitem;

public class StasPos {
	
	private String sta_mac;
	private int environment_id;
	private int map_id;
	private int pos_x;
	private int pos_y;
	private int pos_z;
	private String datetime;
	
	public String getSta_mac() {
		return sta_mac;
	}
	public void setSta_mac(String sta_mac) {
		this.sta_mac = sta_mac;
	}
	public int getEnvironment_id() {
		return environment_id;
	}
	public void setEnvironment_id(int environment_id) {
		this.environment_id = environment_id;
	}
	public int getMap_id() {
		return map_id;
	}
	public void setMap_id(int map_id) {
		this.map_id = map_id;
	}
	public int getPos_x() {
		return pos_x;
	}
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	public int getPos_y() {
		return pos_y;
	}
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	public int getPos_z() {
		return pos_z;
	}
	public void setPos_z(int pos_z) {
		this.pos_z = pos_z;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	

}
