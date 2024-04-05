package com.sangam.muscleplay.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {
    @Autowired
    private SupportService supportService;

    @GetMapping("/support")
    String getSupport(Model model) {
        try {
            String responseModel = supportService.getSupport();
            model.addAttribute("support", responseModel);
            return "support";
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return "error";
        }

    }
}
