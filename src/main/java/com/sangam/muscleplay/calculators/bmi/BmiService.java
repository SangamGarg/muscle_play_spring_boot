package com.sangam.muscleplay.calculators.bmi;

import org.springframework.web.bind.annotation.RequestParam;

public interface BmiService {
    public float getBmi(float weight, float height);

    public String determineHealthStatus(float bmi);
}
