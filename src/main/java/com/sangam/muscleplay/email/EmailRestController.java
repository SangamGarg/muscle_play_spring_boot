package com.sangam.muscleplay.email;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String sendMail(@RequestBody EmailRequestBody emailRequestBody) {
        try {
            return emailApiService.sendMail(emailRequestBody);
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }

}
