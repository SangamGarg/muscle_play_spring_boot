package com.sangam.muscleplay.contactUs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    @GetMapping("/contactUs")
    String getContactUs(Model model) {
        try {
            String responseModel = contactUsService.getContactUs();
            model.addAttribute("contactUs", responseModel);
            return "contactUs";
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return "error";
        }
    }
}
