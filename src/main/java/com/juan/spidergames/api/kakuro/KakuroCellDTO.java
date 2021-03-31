package com.juan.spidergames.api.kakuro;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.juan.spidergames.domain.kakuro.cell.KakuroCell.CellType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Transfer object for any cell type")
public class KakuroCellDTO {
	
	@ApiModelProperty(value = "One of the cell types in enum", required = true)
	private CellType cellType;
	
	@Min(3)
	@Max(45)
	@ApiModelProperty(value = "Reference to the sum of numbers in white cells on the right")
	private Integer rightReference;
	
	@Min(3)
	@Max(45)
	@ApiModelProperty(value = "Reference to the sum of numbers in white cells below")
	private Integer downReference;
	
	@Min(1)
	@Max(9)
	@ApiModelProperty(value = "Value inside the white cell if present")
	private Integer value;

}
