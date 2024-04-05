package com.sangam.muscleplay.calculators.burned_calories_from_activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "burnedcalories")
public class BurnedCaloriesResponseModel {
    private String name;
    private int calories_per_hour;
    private int duration_minutes;
    private int total_calories;
}
