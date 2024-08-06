package com.sangam.muscleplay.feedback;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeedbackRequestBody {

    @NotBlank(message = "Email cannot be null")
    private String email;

    @NotBlank(message = "Feedback cannot be null")
    private String feedback;

}
