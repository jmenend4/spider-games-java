package com.juan.spidergames.domain.kakuro;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.juan.spidergames.domain.kakuro.cell.KakuroCell;
import com.juan.spidergames.enums.Dificulty;
import com.juan.spidergames.enums.KakuroStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "kakuros")
public class Kakuro {
	
	@Id
	private String id;
	
	private Dificulty dificulty;
	
	@Min(3)
	@Max(14)
	private Integer height;
	
	@Min(3)
	@Max(14)
	private Integer width;
	
	private KakuroStatus status;
	
	@Valid
	@NotEmpty
	private List<List<KakuroCell>> grid;
	
	@CreatedDate
	private LocalDateTime createdOn;
	
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedOn;
	
	private String updatedBy;
}
