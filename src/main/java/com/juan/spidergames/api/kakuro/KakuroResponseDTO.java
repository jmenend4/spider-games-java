package com.juan.spidergames.api.kakuro;

import com.juan.spidergames.api.responses.BaseBodyResponse;
import com.juan.spidergames.api.kakuro.KakuroResponseDTO.KakuroResultDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Response of a single kakuro")
public class KakuroResponseDTO extends BaseBodyResponse<KakuroResultDTO> {
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class KakuroResultDTO {
		
		@ApiModelProperty
		private KakuroDTO kakuro;
	}
}
