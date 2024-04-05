package com.sangam.muscleplay.calculators.idealweight;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IdealWeightServiceImpl implements IdealWeightService {
    @Override
    public IdealWeightData idealWeight(float height, String gender) {
        float hamwi = calculateHamwiIdealWeight(height, gender);
        float devine = calculateDevineIdealWeight(height, gender);
        float miller = calculateMillerIdealWeight(height, gender);
        float robinson = calculateRobinsonIdealWeight(height, gender);

        String aboutIdealWeight = "By Maintaining a healthy weight, you lower your risk of developing serious health problems.";
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Fidealweight.jpg?alt=media&token=06f52186-0f7d-44b3-81a1-4b7f2d5070ee";

        return new IdealWeightData(createMap(hamwi, devine, miller, robinson), imageUrl, aboutIdealWeight);
    }

    private static Map<String, Object> createMap(float hamwi, float devine, float miller, float robinson) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("Hamwi", hamwi);
        map.put("Devine", devine);
        map.put("Miller", miller);
        map.put("Robinson", robinson);
        return map;
    }

    public float calculateHamwiIdealWeight(float height, String gender) {
        // Calculate Hamwi ideal weight based on height and gender
        float idealWeight;
        if (gender.equalsIgnoreCase("male")) {
            idealWeight = 48f + 2.7f * ((height - 152.4f) / 2.54f);
        } else {
            idealWeight = 45.5f + 2.2f * ((height - 152.4f) / 2.54f);
        }
        return Float.parseFloat(String.format("%.2f", idealWeight));
    }

    private float calculateDevineIdealWeight(float height, String gender) {
        // Calculate Devine ideal weight based on height and gender
        float idealWeight;
        if (gender.equalsIgnoreCase("male")) {
            idealWeight = 50f + 2.3f * ((height - 152.4f) / 2.54f);
        } else {
            idealWeight = 45.5f + 2.3f * ((height - 152.4f) / 2.54f);
        }
        return Float.parseFloat(String.format("%.2f", idealWeight));
    }

    private float calculateMillerIdealWeight(float height, String gender) {
        // Calculate Miller ideal weight based on height and gender
        float idealWeight;
        if (gender.equalsIgnoreCase("male")) {
            idealWeight = 56.2f + 1.41f * ((height - 152.4f) / 2.54f);
        } else {
            idealWeight = 53.1f + 1.36f * ((height - 152.4f) / 2.54f);
        }
        return Float.parseFloat(String.format("%.2f", idealWeight));
    }

    private float calculateRobinsonIdealWeight(float height, String gender) {
        // Calculate Robinson ideal weight based on height and gender
        float idealWeight;
        if (gender.equalsIgnoreCase("male")) {
            idealWeight = 52f + 1.9f * ((height - 152.4f) / 2.54f);
        } else {
            idealWeight = 49f + 1.7f * ((height - 152.4f) / 2.54f);
        }
        return Float.parseFloat(String.format("%.2f", idealWeight));
    }
}
