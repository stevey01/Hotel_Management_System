package com.example.login.service;

import com.example.login.dto.UserDTO;
import com.example.login.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    User addUser(User user);
    User updateUser(User user);
    User findUser(Long id);
    List<User> getAllUsers();
    String deleteUser(Long id);
    boolean findIfIdPresent(Long userId);
    User convertUserDTO2User(UserDTO userDTO);
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
