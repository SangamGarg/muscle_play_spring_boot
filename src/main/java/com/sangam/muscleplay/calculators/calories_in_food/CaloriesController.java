package com.sangam.muscleplay.calculators.calories_in_food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriesController {
    @Autowired
    private CaloriesService caloriesService;

    @GetMapping("/calorie")
    public ResponseEntity<?> getRecipes(@RequestParam String query) {
        try {
            List<CaloriesResponseModel> responseModel = caloriesService.getRecipes(query);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
