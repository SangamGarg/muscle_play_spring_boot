package com.sangam.muscleplay.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document(collection = "support")
public class SupportResponseModel {
    private String email;
    private String phone;
    private String supportText;
    private List<FaqQuestions> faqQuestions;
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class FaqQuestions {
    private String question;
    private String answer;
}


