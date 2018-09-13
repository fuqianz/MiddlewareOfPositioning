package edu.sse.ustc.innerclass;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TagPath {

	private byte[] tagId;
	private Date time;
	private List<PointContract> path;

	public byte[] getTagId() {
		return tagId;
	}

	public void setTagId(byte[] tagId) {
		this.tagId = tagId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<PointContract> getPath() {
		return path;
	}

	public void setPath(List<PointContract> path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "TagPath [tagId=" + Arrays.toString(tagId) + ", time=" + time + ", path=" + path + "]";
	}

}
