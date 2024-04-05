package com.sangam.muscleplay.calculators.bodyfat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BodyFatResponse {
    private String request_result;
    private BodyFatData data;
}
