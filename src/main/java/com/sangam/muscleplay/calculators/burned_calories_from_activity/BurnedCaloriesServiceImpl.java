package com.sangam.muscleplay.calculators.burned_calories_from_activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BurnedCaloriesServiceImpl implements BurnedCaloriesService {
    @Autowired
    private BurnedCaloriesRepository burnedCaloriesRepository;

    @Override
    public List<BurnedCaloriesResponseModel> getBurnerCalories(String activity, float weight, int duration) {
        List<BurnedCaloriesResponseModel> activities = burnedCaloriesRepository.findAll();
        List<BurnedCaloriesResponseModel> matching = new ArrayList<>();
        // Iterate over each exercise and check if the name matches
        for (BurnedCaloriesResponseModel activit : activities) {
            if (activit.getName().equalsIgnoreCase(activity)) {
                matching.add(activit);
            }
        }
        return matching;
    }
}

//This calculator estimates calories burned using the following equation.
//
//Calories =
//Time × MET × Body Weight
//200
//Where time is in the unit of minutes and body weight is in the unit of kilograms.
//
//Many studies have been conducted to determine the number of calories expended while conducting certain activities. Our calculator uses data from these studies to determine the MET for certain activities, along with the equation above, to estimate calories burned given the duration an activity is performed and body mass.