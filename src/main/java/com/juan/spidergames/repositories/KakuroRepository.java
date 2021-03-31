package com.juan.spidergames.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.juan.spidergames.domain.kakuro.Kakuro;
import com.juan.spidergames.enums.Difficulty;

public interface KakuroRepository extends MongoRepository<Kakuro, String>{
	
	Page<Kakuro> findByDifficulty(Difficulty difficulty, Pageable pageable);

}
