package com.sangam.muscleplay.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${email.service.api.key}")
    private String apiKey;

    public String sendMail(EmailRequestBody emailRequestBody) {
        String url = "https://send.api.mailtrap.io/api/send";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestJson = String.format("{\"from\":{\"email\":\"mailtrap@demomailtrap.com\",\"name\":\"MusclePlay Contact\"},\"to\":[{\"email\":\"muscleplaywork1908@gmail.com\"}],\"subject\":\"%s\",\"text\":\"%s\",\"category\":\"Integration Test\"}", emailRequestBody.getSubject(), emailRequestBody.getBody());

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return "Email Send Successfully";
        } else {
            throw new RuntimeException("Failed to send email: " + response.getStatusCode());
        }
    }


    public String sendMailWebsite(EmailWebsiteRequestBody emailRequestBody) {
        String url = "https://send.api.mailtrap.io/api/send";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestJson = String.format("{\"from\":{\"email\":\"mailtrap@demomailtrap.com\",\"name\":\"MusclePlay Contact Website\"}," + "\"to\":[{\"email\":\"muscleplaywork1908@gmail.com\"}]," + "\"subject\":\"%s\",\"text\":\"From: %s (%s)\\n\\n%s\",\"category\":\"Integration Test\"}", emailRequestBody.getSubject(), emailRequestBody.getName(), emailRequestBody.getEmail(), emailRequestBody.getBody());

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return "Email sent successfully";
        } else {
            throw new RuntimeException("Failed to send email: " + response.getStatusCode());
        }
    }
}

