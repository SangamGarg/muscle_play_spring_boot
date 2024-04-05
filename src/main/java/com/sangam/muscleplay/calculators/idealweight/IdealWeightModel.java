package com.sangam.muscleplay.calculators.idealweight;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdealWeightModel {
    @NotNull(message = "Height Cannot Be Null")
    private float height;
    @NotNull(message = "Gender Cannot Be Null")
    private String gender;
}
