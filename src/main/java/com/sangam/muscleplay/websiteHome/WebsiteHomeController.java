package com.sangam.muscleplay.websiteHome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteHomeController {
    @GetMapping
    String getHomePage(Model model) {
        model.addAttribute("title", "Muscle Play");
        return "home";

    }
}
