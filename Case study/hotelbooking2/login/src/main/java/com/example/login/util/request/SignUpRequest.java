package com.example.login.util.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "SignUpRequest Model Information"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @Schema(
            description = "User FirstName"
    )
    @NotEmpty(message = "User FirstName should not be null or empty")
    private String firstName;
    @Schema(
            description = "User LastName"
    )
    @NotEmpty(message = "User LastName should not be null or empty")
    private String lastName;
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
