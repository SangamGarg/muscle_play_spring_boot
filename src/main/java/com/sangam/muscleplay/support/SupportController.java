package com.sangam.muscleplay.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SupportController {
    @Autowired
    private SupportService supportService;

    @GetMapping("/support")
    String getSupport(Model model) {
        try {
            SupportResponseModel responseModel = supportService.getSupport();
            model.addAttribute("support", responseModel);
            return "support";
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return "error";
        }

    }


}
