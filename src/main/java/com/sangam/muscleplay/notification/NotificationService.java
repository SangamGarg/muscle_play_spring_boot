package com.sangam.muscleplay.notification;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    private static final String CREDENTIALS_FILE_PATH = "F:\\MajorProject\\muscleplay-4c289-firebase-adminsdk-8lbb5-8bfa6132df.json";

    private static final String FCM_API_URL = "https://fcm.googleapis.com/v1/projects/muscleplay-4c289/messages:send";

    private final RestTemplate restTemplate = new RestTemplate();

    private String getAccessToken() throws IOException {
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new FileInputStream(CREDENTIALS_FILE_PATH)).createScoped(Collections.singletonList("https://www.googleapis.com/auth/firebase.messaging"));
        googleCredentials.refreshIfExpired();
        return googleCredentials.getAccessToken().getTokenValue();
    }

    public String sendNotification(NotificationRequestBody request) throws IOException {
        String accessToken = getAccessToken();

        Map<String, Object> message = new HashMap<>();
        Map<String, Object> notification = new HashMap<>();
        notification.put("title", request.getTitle());
        notification.put("body", request.getBody());
        message.put("token", request.getToken());
        message.put("notification", notification);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("message", message);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(FCM_API_URL, new HttpEntity<>(requestBody, createHeaders(accessToken)), String.class);

        return response;
    }

    private HttpHeaders createHeaders(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
