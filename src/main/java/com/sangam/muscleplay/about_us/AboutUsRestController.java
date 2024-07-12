package com.sangam.muscleplay.about_us;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutUsRestController {
    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping("/about")
    private ResponseEntity<?> getAboutUsRest() {
        try {
            AboutUsResponseModel responseModel = aboutUsService.getAboutUs();
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
