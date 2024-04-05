package com.sangam.muscleplay.calculators.bodyfat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class BodyFatController {
    @Autowired
    private BodyFatService bodyFatService;

    @PostMapping("/bodyfat")
    private ResponseEntity<?> getBodyFat(@RequestBody BodyFatModel bodyFatModel) {
        try {
            BodyFatData value = bodyFatService.getBodyFat(bodyFatModel);
            BodyFatResponse response = new BodyFatResponse("Successful", new BodyFatData(value.getData(), value.getImageUrl(), value.getFemaleUrl(), value.getMaleUrl(), value.getAboutBodyFat()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
