package com.sangam.muscleplay.calculators.calories_in_food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriesServiceImpl implements CaloriesService {
    @Autowired
    private CaloriesRepository caloriesRepository;

    @Override
    public List<CaloriesResponseModel> getRecipes(String query) {
        List<CaloriesResponseModel> recipes = caloriesRepository.findAll();
        List<CaloriesResponseModel> matchingRecipes = new ArrayList<>();
        // Iterate over each exercise and check if the name matches
        for (CaloriesResponseModel recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(query)) {
                matchingRecipes.add(recipe);
            }
        }
        return matchingRecipes;
    }
}