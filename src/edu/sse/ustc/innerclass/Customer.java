package edu.sse.ustc.innerclass;

import java.util.Arrays;
import java.util.Date;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields
	private Integer cusId;
	private String mac;
	private String model;
	private Date latestTime;
	private Integer latestEnvironmentId;
	private Integer latestMapId;
	private Integer latestX;
	private Integer latestY;
	private Integer latestZ;

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getLatestTime() {
		return latestTime;
	}

	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}

	public Integer getLatestEnvironmentId() {
		return latestEnvironmentId;
	}

	public void setLatestEnvironmentId(Integer latestEnvironmentId) {
		this.latestEnvironmentId = latestEnvironmentId;
	}

	public Integer getLatestMapId() {
		return latestMapId;
	}

	public void setLatestMapId(Integer latestMapId) {
		this.latestMapId = latestMapId;
	}

	public Integer getLatestX() {
		return latestX;
	}

	public void setLatestX(Integer latestX) {
		this.latestX = latestX;
	}

	public Integer getLatestY() {
		return latestY;
	}

	public void setLatestY(Integer latestY) {
		this.latestY = latestY;
	}

	public Integer getLatestZ() {
		return latestZ;
	}

	public void setLatestZ(Integer latestZ) {
		this.latestZ = latestZ;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", mac=" + mac + ", model=" + model
				+ ", latestTime=" + latestTime + ", latestEnvironmentId=" + latestEnvironmentId + ", latestMapId="
				+ latestMapId + ", latestX=" + latestX + ", latestY=" + latestY + ", latestZ=" + latestZ + "]";
	}

}