package com.juan.spidergames.resources;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juan.spidergames.api.kakuro.KakuroDTO;
import com.juan.spidergames.api.kakuro.KakuroResponseDTO;
import com.juan.spidergames.api.paging.PageResponseDTO;
import com.juan.spidergames.api.string.StringResponseDTO;
import com.juan.spidergames.enums.Difficulty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
	@Validated
	@PutMapping
	public ResponseEntity<StringResponseDTO> putKakuro(@Valid @RequestBody KakuroDTO kakuro) {
		return facade.putKakuro(kakuro);
	}
	
	@ApiOperation("Get paged kakuros by dificulty")
	@ApiResponses ({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 406, message = "Not Acceptable"),
        @ApiResponse(code = 416, message = "Pagination error"),
        @ApiResponse(code = 500, message = "Internal server error")})
	@ApiImplicitParam (name = "Authorization", value = "Authorization token", dataType = "String", paramType = "header")
	@GetMapping
	public ResponseEntity<PageResponseDTO<KakuroDTO>> getByDificulty(
			
			@ApiParam(required = true)
			@RequestParam
			Difficulty difficulty,
			
			@Min(0)
			@ApiParam("Page number starting at 0. Default: 0")
			@RequestParam(required = false)
			Integer pageNumber,
			
			@Min(1)
			@Max(100)
			@ApiParam("Page size. Max 100. Default 20")
			@RequestParam(required = false)
			Integer pageSize
	) {
		return this.facade.getByDifficulty(difficulty, pageNumber, pageSize);
	}
	
	
	@ApiOperation("Get one kakuro by ID")
	@ApiResponses ({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 406, message = "Not Acceptable"),
        @ApiResponse(code = 500, message = "Internal server error")})
	@ApiImplicitParam (name = "Authorization", value = "Authorization token", dataType = "String", paramType = "header")
	@GetMapping("{id}")
	public ResponseEntity<KakuroResponseDTO> getById(@PathVariable("id") String id) {
		return this.facade.getById(id);
	}
}
