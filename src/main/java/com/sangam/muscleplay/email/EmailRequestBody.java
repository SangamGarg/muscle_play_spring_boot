package com.sangam.muscleplay.email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestBody {

    @NotBlank(message = "Subject Cannot Be Blank")
    private String subject;

    @NotBlank(message = "Body Cannot Be Blank")
    private String body;
}
