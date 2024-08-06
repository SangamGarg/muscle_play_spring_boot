package com.sangam.muscleplay.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackRestController {
    @Autowired
    private FeedbackService feedbackService;


    @PostMapping("/feedback")
    public ResponseEntity<?> giveFeedback(@Validated @RequestBody FeedbackRequestBody feedbackBodyModel) {

        try {
            return new ResponseEntity<>(feedbackService.giveFeedback(feedbackBodyModel.getEmail(), feedbackBodyModel.getFeedback()), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
