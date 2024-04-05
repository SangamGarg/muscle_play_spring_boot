package com.sangam.muscleplay.calculators.bmi;

import org.springframework.stereotype.Service;

@Service
public class BmiServiceImpl implements BmiService {
    @Override
    public float getBmi(float weight, float height) {
        float h = height / 100;

        return Float.parseFloat(String.format("%.1f", weight / (h * h)));
    }

    @Override
    public String determineHealthStatus(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else if (bmi >= 30.0 && bmi < 34.9) {
            return "Obesity Class 1";
        } else if (bmi >= 35.0 && bmi < 39.9) {
            return "Obesity Class 2";
        } else {
            return "Obesity Class 3";

        }
    }
}
