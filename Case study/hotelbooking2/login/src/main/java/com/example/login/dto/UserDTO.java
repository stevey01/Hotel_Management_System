package com.example.login.dto;

import com.example.login.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Schema(
        description = "User Model Information"
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{
    @Schema(
            description = "User ID"
    )
    @NotEmpty(message = "Should be provided only while updating")
    private Long id;
    @Schema(
            description = "First Name"
    )
    @NotEmpty(message = "First Name should not be null or empty")
    private String firstName;
    @Schema(
            description = "Last Name"
    )
    @NotEmpty(message = "Last Name should not be null or empty")
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
    @Schema(
            description = "Role"
    )
    @NotEmpty(message = "Role should MANAGER OR RECEPTIONIST")
    private Role role;

}