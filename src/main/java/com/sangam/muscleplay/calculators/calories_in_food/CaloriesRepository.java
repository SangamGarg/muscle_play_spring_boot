package com.sangam.muscleplay.calculators.calories_in_food;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaloriesRepository extends MongoRepository<CaloriesResponseModel, String> {
}
