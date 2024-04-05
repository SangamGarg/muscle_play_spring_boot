package com.sangam.muscleplay.recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<RecipeResponseModel, String> {
}
