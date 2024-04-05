package com.sangam.muscleplay.calculators.calories_in_food;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "caloriesinfood")
public class CaloriesResponseModel {
    private String name;
    private double calories;
    private double serving_size_g;
    private double protein_g;
    private double carbohydrates_total_g;
    private double fiber_g;
    private double fat_saturated_g;
    private double fat_total_g;
    private double cholesterol_mg;
    private double sugar_g;
    private double sodium_mg;
    private double potassium_mg;
}
