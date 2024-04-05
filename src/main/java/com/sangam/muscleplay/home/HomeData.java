package com.sangam.muscleplay.home;

import com.sangam.muscleplay.calculators.bodyfat.BodyFatData;
import com.sangam.muscleplay.calculators.dailycalories.DailyCaloriesData;
import com.sangam.muscleplay.calculators.idealweight.IdealWeightData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeData {
    private float bmi;
    private IdealWeightData idealWeight;
    private DailyCaloriesData dailyCalories;
    private BodyFatData bodyFat;
}
