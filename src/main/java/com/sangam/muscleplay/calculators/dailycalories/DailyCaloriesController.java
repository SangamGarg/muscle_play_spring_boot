package com.sangam.muscleplay.calculators.dailycalories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class DailyCaloriesController {
    @Autowired
    private DailyCaloriesService dailyCaloriesService;

    @PostMapping("/dailycalories")
    private ResponseEntity<?> getDailyCalories(@RequestBody DailyCaloriesModel dailyCaloriesModel) {
        try {
            DailyCaloriesData value = dailyCaloriesService.getDailyCalories(dailyCaloriesModel);
            DailyCaloriesResponse response = new DailyCaloriesResponse("Successful", new DailyCaloriesData(value.getBMR(), value.getGoals(), value.getImageUrl(), value.getAboutDailyCalories()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
