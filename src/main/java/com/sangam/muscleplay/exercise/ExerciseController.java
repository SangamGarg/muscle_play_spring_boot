package com.sangam.muscleplay.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercise")
    public ResponseEntity<?> getExercise(@RequestParam String name, @RequestParam String type, @RequestParam String muscle, @RequestParam String difficulty) {
        try {
            List<ExerciseResponseModel> exerciseResponseModel = exerciseService.getExercise(name, type, muscle, difficulty);
//            ExerciseResponseModel response = new ExerciseResponseModel(exerciseResponseModel.getName(), exerciseResponseModel.getType(), exerciseResponseModel.getMuscle(), exerciseResponseModel.getEquipment(), exerciseResponseModel.getDifficulty(), exerciseResponseModel.getInstructions());
            return new ResponseEntity<>(exerciseResponseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
