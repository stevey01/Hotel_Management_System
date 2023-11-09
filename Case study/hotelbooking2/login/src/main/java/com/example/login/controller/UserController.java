package com.example.login.controller;
import com.example.login.dto.UserDTO;
import com.example.login.entity.Role;
import com.example.login.entity.User;
import com.example.login.exception.InvalidRoleException;
import com.example.login.exception.UserNotFoundException;
import com.example.login.serviceimpl.UserServiceImpl;
import com.example.login.util.RoleValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:8261", "http://localhost:4200"},allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>( userService.getAllUsers(),HttpStatus.OK);
    }
    @PostMapping("/add")
    @Operation(
            summary = "Add User REST API",
            description = "REST API used to add new user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) throws Exception {
        User user = userService.convertUserDTO2User(userDTO);
        String role = user.getRole().toString();
        RoleValidator.validateRole(role);
        if(role.equals(Role.OWNER)) {
            throw new InvalidRoleException("Role : " + role + " not authorised");
        }
        user.setRole(user.getRole());
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        User u = userService.addUser(user);
        return new ResponseEntity<User>(u, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    @Operation(
            summary = "Update User REST API",
            description = "REST API used to update user details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) throws UserNotFoundException, InvalidRoleException {
        User user = userService.convertUserDTO2User(userDTO);
        Long id = user.getId();
        if(userService.findIfIdPresent(id)){
            String role = user.getRole().toString();
            RoleValidator.validateRole(role);
            if(role.equals(Role.OWNER)) {
                throw new InvalidRoleException("Role : " + role + " not authorised");
            }
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            user.setEnabled(true);
            User u = userService.updateUser(user);
            return new ResponseEntity<User>(u,HttpStatus.CREATED);
        }
        else {
            throw new UserNotFoundException("User with Id : "+id+" not found ");
        }
    }

    @DeleteMapping("/deletedById/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) throws UserNotFoundException{

        if(userService.findIfIdPresent(userId)) {
            String user = userService.deleteUser(userId);
            return new ResponseEntity<String>(user,HttpStatus.OK);
        }
        else {
            throw new UserNotFoundException("User with Id : "+userId+" not found ");
        }
    }


    @GetMapping("/getById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException{
        if(userService.findIfIdPresent(userId)) {
            User user = userService.findUser(userId);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
        else {
            throw new UserNotFoundException("User with Id : "+userId+" not found ");
        }
    }



}
