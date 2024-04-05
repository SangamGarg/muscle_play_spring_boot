package com.sangam.muscleplay.home;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HomeResponseModel {
    private String request_result;
    private HomeData bodyStatsData;
    private List<FitnessFactsResponseModel> fitnessFacts;
}
