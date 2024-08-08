package com.sangam.muscleplay.support;

import com.sangam.muscleplay.email.EmailApiService;
import com.sangam.muscleplay.email.EmailRequestBody;
import com.sangam.muscleplay.email.EmailWebsiteRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SupportController {
    @Autowired
    private SupportService supportService;
    @Autowired
    private EmailApiService emailApiService;

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

    @PostMapping("/send-email")
    String sendEmail(@RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String body, Model model) {
        try {
            EmailWebsiteRequestBody emailRequestBody = new EmailWebsiteRequestBody(name, email, subject, body);
            emailApiService.sendMailWebsite(emailRequestBody);
            model.addAttribute("success", "Email sent successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send email: " + e.getMessage());
        }
        return "redirect:/support";
    }

}
