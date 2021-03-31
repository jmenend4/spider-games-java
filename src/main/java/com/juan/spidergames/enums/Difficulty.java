package com.juan.spidergames.enums;

public enum Difficulty {
	
	EASY("E"), HARD("H"), NIGHTMARE("N");
	
	private final String code;
	
	Difficulty(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
