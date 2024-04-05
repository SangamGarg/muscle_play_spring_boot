package com.sangam.muscleplay.recipe;

import java.util.List;

public interface RecipeService {
    public List<RecipeResponseModel> getRecipe(String query);
}
