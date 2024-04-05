package com.sangam.muscleplay.calculators.bodyfat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BodyFatModel {
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
}
