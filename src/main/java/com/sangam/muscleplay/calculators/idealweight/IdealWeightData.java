package com.sangam.muscleplay.calculators.idealweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class IdealWeightData {
    private Map<String, Object> idealWeight;
    private String imageUrl;
    private String aboutIdealWeight;
}
