package com.sangam.muscleplay.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fitnessfacts")
public class FitnessFactsResponseModel {
    private String factsHeadline;
    private String factsSummary;
    private String imageUrl;
}
