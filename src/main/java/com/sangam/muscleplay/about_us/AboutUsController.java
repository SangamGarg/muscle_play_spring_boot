package com.sangam.muscleplay.about_us;

import com.sangam.muscleplay.calculators.calories_in_food.CaloriesResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping("/aboutUs")
    String getAboutUs(Model model) {
        try {
            String responseModel = aboutUsService.getAboutUs();
            model.addAttribute("aboutUs", responseModel);
            return "aboutUs";
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return "error";
        }
    }
}
