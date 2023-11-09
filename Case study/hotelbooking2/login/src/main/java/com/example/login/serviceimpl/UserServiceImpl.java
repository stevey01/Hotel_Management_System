package com.example.login.serviceimpl;

import com.example.login.dto.UserDTO;
import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import com.example.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User addUser(User user) {
        User u = userRepository.save(user);
        u.setPassword("******");
        return u;
    }

    @Override
    public User updateUser(User user) {
        User u = userRepository.save(user);
        u.setPassword("******");
        return u;
    }

    @Override
    public User findUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setPassword("******");
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach( u -> u.setPassword("******"));
        return users;
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return "The User with username: "+user.getUsername()+"deleted successfully";
    }

    @Override
    public boolean findIfIdPresent(Long id) {
        if(userRepository.findById(id).isPresent())
            return true;
        return false;
    }

    @Override
    public User convertUserDTO2User(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return  user;
    }

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User currentUser = null;
        Optional<User> user = userRepository.findByEmail(email);
        if(user==null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("No user found");
        }
        currentUser = user.get();
        currentUser.setPassword("******");
        return currentUser;
    }
}
