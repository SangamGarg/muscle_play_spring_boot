package com.sangam.muscleplay.calculators.idealweight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class IdealWeightController {
    @Autowired
    private IdealWeightService idealWeightService;

    @GetMapping("/idealweight")
    private ResponseEntity<?> getIdealWeight(@RequestParam String gender, @RequestParam float height) {
        try {
            IdealWeightData value = idealWeightService.idealWeight(height, gender);
            IdealWeightResponse response = new IdealWeightResponse("Successful", new IdealWeightData(value.getIdealWeight(), value.getImageUrl(), value.getAboutIdealWeight()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
