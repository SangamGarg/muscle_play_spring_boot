package com.sangam.muscleplay.registration.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestModel {
    @Id
    @NotNull(message = "userId Cannot Be Null")
    private String userId;
    @NotNull(message = "name Cannot Be Null")
    private String name;
    @NotNull(message = "email Cannot Be Null")
    private String email;
    @NotNull(message = "phone Cannot Be Null")
    private String phone;
}
