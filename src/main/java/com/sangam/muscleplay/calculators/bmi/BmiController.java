package com.sangam.muscleplay.calculators.bmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class BmiController {
    @Autowired
    private BmiService bmiService;

    @GetMapping("/bmi")
    private ResponseEntity<?> getBmi(@RequestParam float weight, @RequestParam float height) {

        try {
            float bmiValue = bmiService.getBmi(weight, height);

            String healthStatus = bmiService.determineHealthStatus(bmiValue);
            String imageUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Fbmimeter.png?alt=media&token=06f28e00-a897-4c26-ac32-7d4426d7d2c0";
            String aboutBmi = "A BMI of 18.5 – 24.9 indicates that you are at a healthy weight for your height. By Maintaining a healthy weight, you lower your risk of developing serious health problems.";
            BmiResponse response = new BmiResponse("Successful", new BmiData(bmiValue, healthStatus, "18.5 - 25", imageUrl, aboutBmi));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
