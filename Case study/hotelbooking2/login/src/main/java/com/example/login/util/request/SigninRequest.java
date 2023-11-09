package com.example.login.util.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "SigninRequest Model Information"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {
    @Schema(
            description = "User Email"
    )
    @NotEmpty(message = "User email should not be null or empty")
    private String email;
    @Schema(
            description = "password"
    )
    @NotEmpty(message = "password should not be null or empty")
    private String password;
}