package com.sangam.muscleplay.home;

import com.sangam.muscleplay.calculators.bmi.BmiService;
import com.sangam.muscleplay.calculators.bodyfat.BodyFatData;
import com.sangam.muscleplay.calculators.bodyfat.BodyFatModel;
import com.sangam.muscleplay.calculators.bodyfat.BodyFatService;
import com.sangam.muscleplay.calculators.dailycalories.DailyCaloriesData;
import com.sangam.muscleplay.calculators.dailycalories.DailyCaloriesModel;
import com.sangam.muscleplay.calculators.dailycalories.DailyCaloriesService;
import com.sangam.muscleplay.calculators.idealweight.IdealWeightData;
import com.sangam.muscleplay.calculators.idealweight.IdealWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private BmiService bmiService;
    @Autowired
    private IdealWeightService idealWeightService;

    @Autowired
    private DailyCaloriesService dailyCaloriesService;

    @Autowired
    private BodyFatService bodyFatService;
    @Autowired
    private FitnessFactsRepository fitnessFactsRepository;

    @Override
    public HomeResponseModel getHomeData(HomeRequestBody requestBody) {
        float bmi = bmiService.getBmi(requestBody.getWeight(), requestBody.getHeight());

        IdealWeightData idealWeightData = idealWeightService.idealWeight(requestBody.getHeight(), requestBody.getGender());

        DailyCaloriesData dailyCaloriesData = dailyCaloriesService.getDailyCalories(new DailyCaloriesModel(requestBody.getAge(), requestBody.getGender(), requestBody.getWeight(), requestBody.getHeight(), requestBody.getActivityLevel()));

        BodyFatData bodyFatData = bodyFatService.getBodyFat(new BodyFatModel(requestBody.getAge(), requestBody.getGender(), requestBody.getWeight(), requestBody.getHeight(), requestBody.getWaist(), requestBody.getHip(), requestBody.getNeck()));
        List<FitnessFactsResponseModel> fitnessFactsList = fitnessFactsRepository.findAll();

        return new HomeResponseModel("successful", new HomeData(bmi, idealWeightData, dailyCaloriesData, bodyFatData), fitnessFactsList);
    }
}
