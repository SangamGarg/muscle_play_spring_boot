package com.sangam.muscleplay.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class HomeResponseModel {
    private String request_result;
    private HomeData bodyStatsData;
    private List<FitnessFactsResponseModel> fitnessFacts;
    private ShowImages showImages;
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class HomeData {
    private float bmi;
    private Map<String, Object> idealWeight;
    private Map<String, Object> dailyCalories;
    private Map<String, Object> bodyFat;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fitnessfacts")
class FitnessFactsResponseModel {
    private String factsHeadline;
    private String factsSummary;
    private String imageUrl;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class ShowImages {
    private List<String> viewFlipperImages;
    private List<String> sliderImages;
}


