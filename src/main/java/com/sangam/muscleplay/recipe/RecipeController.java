package com.sangam.muscleplay.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe")
    public ResponseEntity<?> getRecipe(@RequestParam String query) {
        try {
            List<RecipeResponseModel> response = recipeService.getRecipe(query);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
