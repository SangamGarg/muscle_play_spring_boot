package com.sangam.muscleplay.calculators.burned_calories_from_activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BurnedCaloriesController {
    @Autowired
    private BurnedCaloriesService burnedCaloriesService;

    @GetMapping("/burnedcalorie")
    public ResponseEntity<?> getBurnedCalories(@RequestParam String activity, @RequestParam float weight, @RequestParam int duration) {
        try {
            List<BurnedCaloriesResponseModel> response = burnedCaloriesService.getBurnerCalories(activity, weight, duration);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
