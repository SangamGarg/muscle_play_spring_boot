package com.sangam.muscleplay.exercise;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ExerciseService {

    public List<ExerciseResponseModel> getExercise(String name, String type, String muscle, String difficulty);
}
