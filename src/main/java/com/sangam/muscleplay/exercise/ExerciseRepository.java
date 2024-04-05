package com.sangam.muscleplay.exercise;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends MongoRepository<ExerciseResponseModel, String> {
    List<ExerciseResponseModel> findByNameAndTypeAndMuscleAndDifficulty(String name, String type, String muscle, String difficulty);
}
