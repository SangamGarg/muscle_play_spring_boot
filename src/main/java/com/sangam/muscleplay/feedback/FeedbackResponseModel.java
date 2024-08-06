package com.sangam.muscleplay.feedback;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "Feedbacks")
public class FeedbackResponseModel {

    @NotBlank(message = "Email cannot be null")
    private String email;

    private List<@NotBlank(message = "Feedback cannot be null") String> feedbacks = new ArrayList<>();
}
