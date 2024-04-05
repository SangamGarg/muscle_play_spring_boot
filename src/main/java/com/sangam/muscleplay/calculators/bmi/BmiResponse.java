package com.sangam.muscleplay.calculators.bmi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BmiResponse {
    private String request_result;
    private BmiData data;
}
