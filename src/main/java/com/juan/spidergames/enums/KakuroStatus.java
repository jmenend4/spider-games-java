package com.juan.spidergames.enums;

public enum KakuroStatus {
	
	DRAFT("D"),
	READY("R"), 
	IN_PROGRESS("I");
	
	private final String code;
	
	KakuroStatus(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
