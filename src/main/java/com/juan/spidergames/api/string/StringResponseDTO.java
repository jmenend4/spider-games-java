package com.juan.spidergames.api.string;

import com.juan.spidergames.api.responses.BaseBodyResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(description = "Response with a single string")
public class StringResponseDTO extends BaseBodyResponse<String> {

}
