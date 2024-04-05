package com.sangam.muscleplay.calculators.calories_in_food;

import java.util.List;

public interface CaloriesService {
    public List<CaloriesResponseModel> getRecipes(String query);
}
