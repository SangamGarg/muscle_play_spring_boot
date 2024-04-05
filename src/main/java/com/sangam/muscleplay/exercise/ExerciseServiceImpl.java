package com.sangam.muscleplay.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<ExerciseResponseModel> getExercise(String name, String type, String muscle, String difficulty) {
        List<ExerciseResponseModel> exercises = exerciseRepository.findAll();
        List<ExerciseResponseModel> matchingExercises = new ArrayList<>();
        // Iterate over each exercise and check if the name matches
        for (ExerciseResponseModel exercise : exercises) {
            if (exercise.getName().equalsIgnoreCase(name)) {
                matchingExercises.add(exercise);
            }
        }
        return matchingExercises;
    }
}
