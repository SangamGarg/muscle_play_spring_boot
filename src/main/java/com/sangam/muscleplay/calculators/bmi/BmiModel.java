package com.sangam.muscleplay.calculators.bmi;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BmiModel {
    @NotNull(message = "Weight Cannot Be Null")
    private float weight;
    @NotNull(message = "Height Cannot Be Null")
    private float height;
}
