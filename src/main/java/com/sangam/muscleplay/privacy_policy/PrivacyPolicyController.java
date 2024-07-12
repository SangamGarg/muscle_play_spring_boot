package com.sangam.muscleplay.privacy_policy;

import com.sangam.muscleplay.support.SupportResponseModel;
import com.sangam.muscleplay.support.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivacyPolicyController {

    @Autowired
    private PrivacyPolicyService privacyPolicyService;

    @GetMapping("/privacyPolicy")
    String getPrivacyPolicy(Model model) {
        try {
            PrivacyPolicyResponseModel responseModel = privacyPolicyService.getPrivacyPolicy();
            model.addAttribute("privacyPolicy", responseModel);
            System.out.println(responseModel.getPrivacyPolicyText());
            return "privacyPolicy";
        } catch (Exception e) {
            model.addAttribute("error", e.getLocalizedMessage());
            return "error";
        }

    }

}
