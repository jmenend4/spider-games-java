package com.juan.spidergames.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "kakuros")
public class Kakuro {
	
	@Id
	private String id;

	private Integer height;
	
	private Integer width;
	
	private KakuroStatus status;
	
	private List<KakuroCell> cells;
}
