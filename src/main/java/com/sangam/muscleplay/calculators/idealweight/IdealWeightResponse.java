package com.sangam.muscleplay.calculators.idealweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IdealWeightResponse {
    private String request_result;
    private IdealWeightData data;
}
