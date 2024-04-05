package com.sangam.muscleplay.calculators.bmi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BmiData {
    private float bmi;
    private String health;
    private String healthy_bmi_range;
    private String imageUrl;
    private String aboutBmi;
}
