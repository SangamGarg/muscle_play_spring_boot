package com.sangam.muscleplay.calculators.bodyfat;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class BodyFatServiceImpl implements BodyFatService {
    @Override
    public BodyFatData getBodyFat(BodyFatModel bodyFatModel) {
        // Calculate body fat using the U.S. Navy Method
        float bodyFatPercentage = calculateBodyFat(bodyFatModel.getGender(), bodyFatModel.getWeight(), bodyFatModel.getHeight(), bodyFatModel.getWaist(), bodyFatModel.getHip(), bodyFatModel.getNeck());

        // Calculate body fat mass
        float bodyFatMass = calculateBodyFatMass(bodyFatModel.getWeight(), bodyFatPercentage);

        // Calculate lean body mass
        float leanBodyMass = calculateLeanBodyMass(bodyFatModel.getWeight(), bodyFatMass);

        // Calculate body fat using the BMI method
        float bodyFatFromBMI = calculateBodyFatFromBMI(bodyFatModel.getGender(), bodyFatModel.getHeight(), bodyFatModel.getWeight(), bodyFatModel.getAge());

        // Create a map to store the calculated data
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("BodyFatPercentage (U.S.NAVY)", bodyFatPercentage);
        data.put("BodyFatMass", bodyFatMass);
        data.put("LeanBodyMass", leanBodyMass);
        data.put("BodyFatFromBMI", bodyFatFromBMI);
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Fbody-fat-photos-1.jpg?alt=media&token=e23b6c54-11f2-40fd-87fb-cc7b7551eeef";
        String aboutBodyFat = "Achieving a healthy body fat percentage is essential for overall well-being. Maintaining an optimal level of body fat can help enhance physical performance, promote organ function, and contribute to a balanced metabolism. Striving for a healthy body fat percentage through regular exercise and a nutritious diet can support long-term health and vitality.";
        String maleUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Fmale%20body%20fat-MnhY8.png?alt=media&token=99977bdc-a008-4993-9669-14594a9d4546";
        String femaleUrl = "https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/calculatorsimages%2Ffemale%20body%20fat-doP5P.png?alt=media&token=d70c3f76-ad04-4cbf-adee-0405664a85e0";

        return new BodyFatData(data, imageUrl, femaleUrl, maleUrl, aboutBodyFat);
    }

    public float calculateBodyFat(String gender, float weight, float height, float waist, float hip, float neck) {
        // Calculate body fat percentage using the U.S. Navy Method
        float bodyFatPercentage;
        if (gender.equalsIgnoreCase("male")) {
            // Formula for males
            bodyFatPercentage = (float) (495 / (1.0324 - (0.19077 * Math.log10(waist - neck)) + (0.15456 * Math.log10(height)))) - 450;

        } else {
            // Formula for females
            bodyFatPercentage = (float) (495 / (1.29579 - (0.35004 * Math.log10(waist + hip - neck)) + (0.22100 * Math.log10(height)))) - 450;
        }
        return Float.parseFloat(String.format("%.2f", bodyFatPercentage));
    }

    private float calculateBodyFatMass(float weight, float bodyFatPercentage) {
        // Calculate body fat mass
        return Float.parseFloat(String.format("%.2f", weight * bodyFatPercentage / 100));
    }
    private float calculateLeanBodyMass(float weight, float bodyFatMass) {
        // Calculate lean body mass
        return Float.parseFloat(String.format("%.2f", weight - bodyFatMass));
    }

    private float calculateBodyFatFromBMI(String gender, float height, float weight, int age) {
        // Calculate body fat using the BMI method
        float h = height / 100;
        float bmi = weight / (h * h); // BMI formula: weight (kg) / height (cm) ^ 2
        if (gender.equalsIgnoreCase("male")) {
            // Formula for males
            return Float.parseFloat(String.format("%.2f", ((1.20 * bmi) + (0.23 * age) - 16.2)));

        } else {
            // Formula for females
            return Float.parseFloat(String.format("%.2f", ((1.20 * bmi) + (0.23 * age) - 5.4)));
        }
    }

}
