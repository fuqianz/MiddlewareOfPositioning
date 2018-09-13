package edu.sse.ustc.innerclass;

import edu.sse.ustc.innerclass.myenum.TagType;


public class Tag {

	private byte[] tagId;
	private String name;
	private TagType tagType;
	private String remark;
	private boolean enable;
	private String charageTime;
	private String rate;
	private String model;
	private String mac;

	public byte[] getTagId() {
		return tagId;
	}

	public void setTagId(byte[] tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TagType getTagType() {
		return tagType;
	}

	public void setTagType(TagType tagType) {
		this.tagType = tagType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getCharageTime() {
		return charageTime;
	}

	public void setCharageTime(String charageTime) {
		this.charageTime = charageTime;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "TagContract [tagId=" + tagId + ", name=" + name + ", tagType=" + tagType + ", remark=" + remark
				+ ", enable=" + enable + ", charageTime=" + charageTime + ", rate=" + rate + ", model=" + model
				+ ", mac=" + mac + "]";
	}

}
