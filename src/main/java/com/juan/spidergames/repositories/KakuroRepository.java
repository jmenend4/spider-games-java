package com.juan.spidergames.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.juan.spidergames.domain.kakuro.Kakuro;

public interface KakuroRepository extends MongoRepository<Kakuro, String>{

}
