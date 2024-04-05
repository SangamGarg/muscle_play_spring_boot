package com.sangam.muscleplay.contactUs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {

    @GetMapping("/contactUs")
    String getContactUs(Model model) {
        model.addAttribute("contactUs", "This is Contact Us Section");
        return "contactUs";
    }
}
