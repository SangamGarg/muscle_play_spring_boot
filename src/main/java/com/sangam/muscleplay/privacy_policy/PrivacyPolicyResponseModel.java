package com.sangam.muscleplay.privacy_policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "privacyPolicy")
public class PrivacyPolicyResponseModel {

    private String privacyPolicyText;
    private List<PrivacyPolicyQuestions> privacyPolicyQuestions;
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class PrivacyPolicyQuestions {

    private String questions;
    private String answers;
}