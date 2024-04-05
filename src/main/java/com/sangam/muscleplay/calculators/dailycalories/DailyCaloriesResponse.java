package com.sangam.muscleplay.calculators.dailycalories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DailyCaloriesResponse {
    private String request_result;
    private DailyCaloriesData data;
}
