package com.example.login.controller;


import com.example.login.config.JwtUtils;
import com.example.login.entity.User;
import com.example.login.service.AuthenticationService;
import com.example.login.serviceimpl.UserServiceImpl;
import com.example.login.util.request.SignUpRequest;
import com.example.login.util.request.SigninRequest;
import com.example.login.util.response.JwtAuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(
        name = "Authentication REST APIs ",
        description = "REST APIs - SignIn User, SignUp User"
)
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = {"http://localhost:4200"},allowedHeaders = "*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    
    
   	@Autowired
   	private AuthenticationManager authenticationManager;
   	
   	@Autowired
   	private UserServiceImpl userDetailsService;
   	
    @Autowired
    private UserServiceImpl userService;
    
    
   	
   	
   	
    @PostMapping("/signup")
    @Operation(
            summary = "SignUp User REST API",
            description = "Authenticate REST API used to register user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    @Operation(
            summary = "SignIn User REST API",
            description = "Authenticate REST API used to login user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
    	System.out.println("/nSaurabh login");
        return ResponseEntity.ok(authenticationService.signin(request));
        
    }
   
    @GetMapping("/current-user")
    @Operation(
            summary = "Get Current User REST API",
            description = "API used to get current logged in user details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    public User  getCurrentUser(Principal principal) {
        return (User) this.userService.loadUserByEmail(principal.getName());
    }
    
  /*  public User  getCurrentUser() {
        return (User) this.userService.loadUserByEmail("daniel@gmail.com");
    }*/
	
}