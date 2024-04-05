package com.sangam.muscleplay.calculators.bodyfat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class BodyFatData {
    private Map<String, Object> data;
    private String imageUrl;
    private String femaleUrl;
    private String maleUrl;
    private String aboutBodyFat;
}
