package com.juan.spidergames.enums;

public enum Dificulty {
	
	EASY("E"), HARD("H"), NIGHTMARE("N");
	
	private final String code;
	
	Dificulty(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
