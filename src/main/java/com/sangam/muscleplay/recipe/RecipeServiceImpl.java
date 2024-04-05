package com.sangam.muscleplay.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<RecipeResponseModel> getRecipe(String query) {
        List<RecipeResponseModel> recipes = recipeRepository.findAll();
        List<RecipeResponseModel> matchingRecipes = new ArrayList<>();

        // Split the query string into words
        String[] queryWords = query.split("\\s+");

        // Iterate over each recipe
        for (RecipeResponseModel recipe : recipes) {
            // Split the title into words
            String[] titleWords = recipe.getTitle().split("\\s+");
            // Check if any word in the title matches any word in the query
            for (String queryWord : queryWords) {
                if (Arrays.stream(titleWords).anyMatch(titleWord -> titleWord.equalsIgnoreCase(queryWord))) {
                    matchingRecipes.add(recipe);
                    break;  // No need to check further if a match is found
                }
            }
        }
        return matchingRecipes;
    }
}
