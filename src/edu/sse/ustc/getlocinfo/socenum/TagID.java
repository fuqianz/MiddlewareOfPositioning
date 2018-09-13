package edu.sse.ustc.getlocinfo.socenum;

public enum TagID {
	WIFI(1), 
	MOBILEPHONE(2),
	LAPTOP(3), 
	PAD(4), 
	RFID(5);

	private Integer value = null;

	private TagID(Integer value) {
       this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
