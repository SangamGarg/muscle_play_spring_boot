package com.sangam.muscleplay.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recipes")
public class RecipeResponseModel {
    private String title;
    private String ingredients;
    private String servings;
    private String instructions;
}
