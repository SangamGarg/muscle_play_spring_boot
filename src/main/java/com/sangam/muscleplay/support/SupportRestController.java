package com.sangam.muscleplay.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupportRestController {

    @Autowired
    private SupportService supportService;

    @GetMapping("/supportHelp")
    private ResponseEntity<?> getAboutUsRest() {
        try {
            SupportResponseModel responseModel = supportService.getSupport();
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
