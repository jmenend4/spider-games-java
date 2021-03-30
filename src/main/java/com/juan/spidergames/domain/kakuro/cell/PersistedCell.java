package com.juan.spidergames.domain.kakuro.cell;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersistedCell {
	
	private String cellType;
	
	@Min(3)
	@Max(45)
	private Integer rightReference;
	
	@Min(3)
	@Max(45)
	private Integer downReference;
	
	@Min(1)
	@Max(9)
	private Integer value;

}
