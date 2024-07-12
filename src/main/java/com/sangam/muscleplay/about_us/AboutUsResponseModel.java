package com.sangam.muscleplay.about_us;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aboutUs")

public class AboutUsResponseModel {
    private String version;
    private String appName;
    private String developerName;
    private AboutUsLinks aboutUsLinks;
    private List<AboutUsQuestions> aboutUsQuestions;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AboutUsLinks {
    private String websiteLink;
    private String instagramLink;
    private String twitterLink;
    private String youtubeLink;
    private String facebookLink;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class AboutUsQuestions {
    private String question;
    private String answer;
}



