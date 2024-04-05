package com.sangam.muscleplay.home;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HomeRequestBody {
    @NotNull(message = "Age Cannot Be Null")
    private int age;
    @NotNull(message = "Gender Cannot Be Null")
    private String gender;
    @NotNull(message = "Weight Cannot Be Null")
    private float weight;
    @NotNull(message = "Height Cannot Be Null")
    private float height;
    @NotNull(message = "Waist Cannot Be Null")
    private float waist;
    @NotNull(message = "Hip Cannot Be Null")
    private float hip;
    @NotNull(message = "Neck Cannot Be Null")
    private float neck;
    @NotNull(message = "ActivityLevel Cannot Be Null")
    private String activityLevel;
}
