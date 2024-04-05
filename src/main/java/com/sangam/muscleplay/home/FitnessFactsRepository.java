package com.sangam.muscleplay.home;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessFactsRepository extends MongoRepository<FitnessFactsResponseModel, String> {

}
