package com.sangam.muscleplay.calculators.dailycalories;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DailyCaloriesServiceImpl implements DailyCaloriesService {

    @Override
    public DailyCaloriesData getDailyCalories(DailyCaloriesModel dailyCaloriesModel) {
        // Calculate BMR based on gender
        int bmr = calculateBMR(dailyCaloriesModel.getWeight(), dailyCaloriesModel.getHeight(), dailyCaloriesModel.getAge(), dailyCaloriesModel.getGender());

        // Calculate daily calories based on BMR and activity level
        int dailyCalories = calculateDailyCalories(bmr, dailyCaloriesModel.getActivityLevel());

        // Create the response data map
        Map<String, Object> map = new HashMap<>();
        map.put("BMR", bmr);
        map.put("goals", createGoalsMap(dailyCalories));
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Fdailycalories.jpg?alt=media&token=768d3411-b4b7-4c3c-ac4e-634bfdfd6ae3";
        String aboutDailyCalories = "Understanding your daily calorie needs is crucial for maintaining a balanced diet and achieving fitness goals. Calculating your daily calorie requirements based on factors like age, gender, activity level, and metabolism helps ensure you are fueling your body appropriately for optimal health and performance. Tracking your calorie intake can support weight management, muscle gain, or weight loss goals, leading to better overall fitness outcomes.";
        return new DailyCaloriesData(bmr, map, imageUrl, aboutDailyCalories);
    }

    private int calculateBMR(float weight, float height, int age, String gender) {
        // BMR calculation based on gender
        if (gender.equalsIgnoreCase("male")) {
            return (int) ((10 * weight) + (6.25 * height) - (5 * age) + 5);
        } else {
            return (int) ((10 * weight) + (6.25 * height) - (5 * age) - 161);
        }
    }

    private int calculateDailyCalories(int bmr, String activityLevel) {
        // Activity level multiplier based on different levels
        double multiplier = switch (activityLevel.toLowerCase()) {
            case "level_1" -> 1.2; // Sedentary: little or no exercise
            case "level_2" -> 1.375; // Exercise 1-3 times/week
            case "level_3" -> 1.55; // Exercise 4-5 times/week
            case "level_4" -> 1.725; // Daily exercise or intense exercise 3-4 times/week
            case "level_5" -> 1.9; // Intense exercise 6-7 times/week
            case "level_6" -> 2.0;
            default -> 1.2; // Default multiplier for sedentary
            // Very intense exercise daily, or physical job
        };
        // Calculate daily calories based on BMR and activity level
        return (int) (bmr * multiplier);
    }

    private Map<String, Object> createGoalsMap(int dailyCalories) {
        // Create goals map with different weight goals and corresponding calorie requirements
        Map<String, Object> goalsMap = new LinkedHashMap<>();
        goalsMap.put("maintain weight", dailyCalories);
        goalsMap.put("Mild weight loss", createWeightLossMap("0.25 kg", dailyCalories - 250));
        goalsMap.put("Weight loss", createWeightLossMap("0.50 kg", dailyCalories - 500));
        goalsMap.put("Extreme weight loss", createWeightLossMap("1 kg", dailyCalories - 1000));
        goalsMap.put("Mild weight gain", createWeightGainMap("0.25 kg", dailyCalories + 250));
        goalsMap.put("Weight gain", createWeightGainMap("0.50 kg", dailyCalories + 500));
        goalsMap.put("Extreme weight gain", createWeightGainMap("1 kg", dailyCalories + 1000));
        return goalsMap;
    }

    private Map<String, Object> createWeightGainMap(String weightChange, int calorie) {
        // Create weight goal map with weight change and corresponding calorie requirement
        Map<String, Object> weightMap = new LinkedHashMap<>();
        weightMap.put("gain_weight", weightChange);
        weightMap.put("calory", calorie);
        return weightMap;
    }
    private Map<String, Object> createWeightLossMap(String weightChange, int calorie) {
        // Create weight goal map with weight change and corresponding calorie requirement
        Map<String, Object> weightMap = new LinkedHashMap<>();
        weightMap.put("loss_weight", weightChange);
        weightMap.put("calory", calorie);
        return weightMap;
    }
}
