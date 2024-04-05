package com.sangam.muscleplay.calculators.dailycalories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class DailyCaloriesData {
    private int BMR;
    private Map<String, Object> goals;
    private String imageUrl;
    private String aboutDailyCalories;
}
