package com.sangam.muscleplay.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRestController {
    @Autowired
    private EmailApiService emailApiService;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestBody EmailRequestBody emailRequestBody) {
        try {
            return new ResponseEntity<>(emailApiService.sendMail(emailRequestBody), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send email: " + e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
