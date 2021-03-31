package com.juan.spidergames.enums;

import java.util.Map;

import com.google.common.collect.Maps;

public class EnumUtils {
	
	private static final Map<String, KakuroStatus> kakuroStatusCodeIndex =
			Maps.newHashMapWithExpectedSize(KakuroStatus.values().length);
	
	static {
		for (KakuroStatus status : KakuroStatus.values()) {
			kakuroStatusCodeIndex.put(status.getCode(), status);
		}
	}
	
	public static KakuroStatus getKakuroStatusByCode(String code) {
		return kakuroStatusCodeIndex.get(code);
	}

	private static final Map<String, Dificulty> dificultyCodeIndex =
			Maps.newHashMapWithExpectedSize(Dificulty.values().length);
	
	static {
		for (Dificulty dificulty : Dificulty.values()) {
			dificultyCodeIndex.put(dificulty.getCode(), dificulty);
		}
	}
	
	public static Dificulty getDificultyByCode(String code) {
		return dificultyCodeIndex.get(code);
	}
}
