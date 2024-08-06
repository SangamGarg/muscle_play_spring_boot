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
import com.sangam.muscleplay.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private HomeRepository fitnessFactsRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public HomeResponseModel getHomeData(HomeRequestBody requestBody) {
        float bmi = bmiService.getBmi(requestBody.getWeight(), requestBody.getHeight());

        IdealWeightData idealWeightData = idealWeightService.idealWeight(requestBody.getHeight(), requestBody.getGender());

        DailyCaloriesData dailyCaloriesData = dailyCaloriesService.getDailyCalories(new DailyCaloriesModel(requestBody.getAge(), requestBody.getGender(), requestBody.getWeight(), requestBody.getHeight(), requestBody.getActivityLevel()));

        BodyFatData bodyFatData = bodyFatService.getBodyFat(new BodyFatModel(requestBody.getAge(), requestBody.getGender(), requestBody.getWeight(), requestBody.getHeight(), requestBody.getWaist(), requestBody.getHip(), requestBody.getNeck()));
        List<FitnessFactsResponseModel> fitnessFactsList = fitnessFactsRepository.findAll();

        List<String> sliderImages = new ArrayList<>();

        try {
            sliderImages = cloudinaryService.getImagesFromFolder("AutoImageSliderImages");
        } catch (Exception e) {
            sliderImages.add("https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/imageSliderImages%2F360_F_267276121_cXC9DR0HelHiMnP49Tz33z8FEpMojr7C.jpg?alt=media&token=8c3f4559-58e4-47da-a663-d6f09a160c4d");
            sliderImages.add("https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/imageSliderImages%2Fdownload.jpg?alt=media&token=adcde026-6e40-48f1-af55-573ac72f290a");
            sliderImages.add("https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/imageSliderImages%2Fimages.png?alt=media&token=eb9bc448-1602-4964-b34c-fc4dd401d1e7");
        }

        List<String> flipperImages = new ArrayList<>();

        try {
            flipperImages = cloudinaryService.getImagesFromFolder("FlipperImages");
        } catch (Exception e) {
            flipperImages.add("https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/viewFlipperImages%2FBMI-And-Water-Protein-Intake-Calculator-Plugin-Fitness-Calculator.png?alt=media&token=579496d8-d0d6-464a-8ba8-83f8638fbae4");
            flipperImages.add("https://firebasestorage.googleapis.com/v0/b/muscleplay-4c289.appspot.com/o/viewFlipperImages%2Fwordpress-fitness-calculators.jpg?alt=media&token=ddb6a9d9-f71b-4e16-b324-57a70ad42774");
        }


        return new HomeResponseModel("successful", new HomeData(bmi, idealWeightData.getIdealWeight(), dailyCaloriesData.getGoals(), bodyFatData.getData()), fitnessFactsList, new ShowImages(flipperImages, sliderImages));
    }
}
