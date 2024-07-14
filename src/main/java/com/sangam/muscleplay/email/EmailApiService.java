package com.sangam.muscleplay.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailApiService {

    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendMail(EmailRequestBody emailRequestBody) {
        String url = "https://send.api.mailtrap.io/api/send";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("e479069b435573c360380f33241bae4a");

        String requestJson = String.format("{\"from\":{\"email\":\"mailtrap@demomailtrap.com\",\"name\":\"MusclePlay Contact\"},\"to\":[{\"email\":\"muscleplaywork1908@gmail.com\"}],\"subject\":\"%s\",\"text\":\"%s\",\"category\":\"Integration Test\"}", emailRequestBody.getSubject(), emailRequestBody.getBody());

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return "Email Send Successfully";
        } else {
            throw new RuntimeException("Failed to send email: " + response.getStatusCode());
        }
    }

}
