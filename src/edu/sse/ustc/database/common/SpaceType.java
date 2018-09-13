package edu.sse.ustc.database.common;

public enum SpaceType {

	CurrentSpace(0), Rectangle(1), Cycle(2);

	private Integer value;

	private SpaceType(Integer value) {

		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
