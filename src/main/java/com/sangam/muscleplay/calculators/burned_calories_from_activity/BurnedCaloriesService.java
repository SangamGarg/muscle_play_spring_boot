package com.sangam.muscleplay.calculators.burned_calories_from_activity;

import java.util.List;

public interface BurnedCaloriesService {
    public List<BurnedCaloriesResponseModel> getBurnerCalories(String activity, float weight, int duration);
}
