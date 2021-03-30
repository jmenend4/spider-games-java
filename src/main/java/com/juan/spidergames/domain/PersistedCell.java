package com.juan.spidergames.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersistedCell {
	
	private String cellType;
	private Integer rightReference;
	private Integer downReference;
	private Integer value;

}
