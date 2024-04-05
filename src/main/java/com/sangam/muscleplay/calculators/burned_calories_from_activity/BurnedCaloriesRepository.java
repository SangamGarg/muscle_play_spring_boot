package com.sangam.muscleplay.calculators.burned_calories_from_activity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurnedCaloriesRepository extends MongoRepository<BurnedCaloriesResponseModel, String> {

}
