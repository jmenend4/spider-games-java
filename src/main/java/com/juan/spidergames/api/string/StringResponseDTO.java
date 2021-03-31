package com.juan.spidergames.api.string;

import com.juan.spidergames.api.responses.BaseBodyResponse;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Response with a single string")
public class StringResponseDTO extends BaseBodyResponse<String> {

}
