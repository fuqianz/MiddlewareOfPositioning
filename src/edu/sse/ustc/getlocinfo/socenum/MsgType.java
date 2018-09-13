package edu.sse.ustc.getlocinfo.socenum;

public enum MsgType {

	REGISTERREQ((short)1),
	REGISTERACK((short)2), 
	REGISTERNAK((short)3), 
	TARGETPOSITION((short)4), 
	TARGETPATH((short)5), 
	REALTIMEEVENT((short)6), 
	TBD((short)7);

	private short value;

	private MsgType(short value) {
		this.value = value;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
}
