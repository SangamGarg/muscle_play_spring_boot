package com.sangam.muscleplay.calculators.dailycalories;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyCaloriesModel {
    @NotNull(message = "Age Cannot Be Null")
    private int age;
    @NotNull(message = "Gender Cannot Be Null")
    private String gender;
    @NotNull(message = "Weight Cannot Be Null")
    private float weight;
    @NotNull(message = "Height Cannot Be Null")
    private float height;
    @NotNull(message = "ActivityLevel Cannot Be Null")
    private String activityLevel;
}
