package com.sangam.muscleplay.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public String giveFeedback(String email, String newFeedback) {
        Optional<FeedbackResponseModel> optionalFeedback = feedbackRepository.findByEmail(email);

        FeedbackResponseModel feedbackBodyModel;
        if (optionalFeedback.isPresent()) {
            feedbackBodyModel = optionalFeedback.get();
        } else {
            feedbackBodyModel = new FeedbackResponseModel();
            feedbackBodyModel.setEmail(email);
        }
        feedbackBodyModel.getFeedbacks().add(newFeedback);
        feedbackRepository.save(feedbackBodyModel);

        return "Feedback submitted successfully";
    }
}
