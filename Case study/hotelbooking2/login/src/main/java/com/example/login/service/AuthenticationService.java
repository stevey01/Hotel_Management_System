package com.example.login.service;

import com.example.login.util.request.SignUpRequest;
import com.example.login.util.request.SigninRequest;
import com.example.login.util.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}