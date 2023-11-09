package com.example.login.util;

import com.example.login.entity.Role;
import com.example.login.exception.InvalidRoleException;

public class RoleValidator {
    public static void validateRole(String role) {
        try {
            Role.valueOf(role);
        } catch (IllegalArgumentException e) {
            throw new InvalidRoleException("Invalid role: " + role);
        }
    }
}
