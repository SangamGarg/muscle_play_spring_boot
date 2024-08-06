package com.sangam.muscleplay.registration.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
@TypeAlias("UserDetailsResponseModel")
public class UserDetailsResponseModel {
    @Id
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String fcmToken;
    private String profileImageUrl = "";
    private String gender = "";
    private int age = 0;
    private Measurements measurements = new Measurements();
    private Notification notification = new Notification();
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Measurements {
    private float height = 0f;
    private float weight = 0f;
    private String activityLevel = "";
    private String goal = "";
    private float hip = 0f;
    private float neck = 0f;
    private float waist = 0f;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Notification {
    private String heading;
    private String subHeading;
    private String date;
    private String time;
}