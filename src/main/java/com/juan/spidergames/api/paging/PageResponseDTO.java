package com.juan.spidergames.api.paging;

import com.juan.spidergames.api.responses.BaseBodyResponse;

import java.util.List;

import com.juan.spidergames.api.paging.PageResponseDTO.ResultPage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PageResponseDTO<T> extends BaseBodyResponse<ResultPage<T>>{
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	@ApiModel(description = "Page header helper")
	public static class ResultPage<T> {
		
		@ApiModelProperty("Page number. Starts at 0.")
		private Integer number;

		@ApiModelProperty("Number of elements in the page.")
		private Integer numberOfElements;

		@ApiModelProperty("Page size.")
		private Integer size;

		@ApiModelProperty("Total elements in the response query.")
		private Long totalElements;

		@ApiModelProperty("Total pages of response.")
		private Integer totalPages;

		@ApiModelProperty("Is the first page.")
		private Boolean isFirst;

		@ApiModelProperty("Is the last page.")
		private Boolean isLast;

		@ApiModelProperty("Has next page.")
		private Boolean hasNext;

		@ApiModelProperty("Has previous page.")
		private Boolean hasPrevious;

		@ApiModelProperty("Page content")
		private List<T> content;
	}
}
