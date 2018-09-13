package edu.sse.ustc.innerclass;

import java.util.Arrays;
import java.util.Date;

public class TagPos {
	
	private Integer tagposId;
	private byte[] tagId;
	private String mac;
	private Integer environmentId;
	private Integer mapId;
	private Integer seqNum;
	private Integer x_pos;
	private Integer y_pos;
	private Integer z_pos;
	private Date time;
	
	
	public Integer getTagposId() {
		return tagposId;
	}

	public void setTagposId(Integer tagposId) {
		this.tagposId = tagposId;
	}
	
	public byte[] getTagId() {
		return tagId;
	}

	public void setTagId(byte[] tagId) {
		this.tagId = tagId;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Integer getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getX_pos() {
		return x_pos;
	}

	public void setX_pos(Integer x_pos) {
		this.x_pos = x_pos;
	}

	public Integer getY_pos() {
		return y_pos;
	}

	public void setY_pos(Integer y_pos) {
		this.y_pos = y_pos;
	}

	public Integer getZ_pos() {
		return z_pos;
	}

	public void setZ_pos(Integer z_pos) {
		this.z_pos = z_pos;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TagPos [tagId=" + Arrays.toString(tagId) + ", mac=" + mac + ", environmentId=" + environmentId
				+ ", mapId=" + mapId + ", seqNum=" + seqNum + ", x_pos=" + x_pos + ", y_pos=" + y_pos + ", z_pos="
				+ z_pos + ", time=" + time + "]";
	}

}
