package com.sangam.muscleplay.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestBody {
    private String token;
    private String title;
    private String body;
}
