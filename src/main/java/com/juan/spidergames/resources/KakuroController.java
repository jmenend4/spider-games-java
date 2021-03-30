package com.juan.spidergames.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.spidergames.api.responses.BaseBodyResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/kakuros")
@Validated
@CrossOrigin
@Api("Operations over persisted kakuros")
@RequiredArgsConstructor
public class KakuroController {
	
	private final KakuroFacade facade;
	
	@ApiOperation("Create or update an existing kakuro")
	@ApiResponses ({
        @ApiResponse(code = 201, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 406, message = "Not Acceptable"),
        @ApiResponse(code = 500, message = "Internal server error")})
	@ApiImplicitParam (name = "Authorization", value = "Authorization token", dataType = "String", paramType = "header")
	@PutMapping
	public ResponseEntity<BaseBodyResponse<String>> putKakuro() {
		return facade.putKakuro();
	}

}
