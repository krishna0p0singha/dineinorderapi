package com.exmaple.dio.service.impl;

import com.exmaple.dio.enums.UserRole;
import com.exmaple.dio.model.Admin;
import com.exmaple.dio.model.Staff;
import com.exmaple.dio.model.User;
import com.exmaple.dio.repository.UserRepository;
import com.exmaple.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        User child = this.createUserByRole(user.getUserRole());
        this.mapToNewUser(user, child);
        return userRepository.save(child);
    }

    @Override
    public User findById(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return  user.get();
    }

    private User createUserByRole(UserRole userRole) {
        User user;
        switch(userRole){
            case ADMIN -> user=new Admin();
            case STAFF -> user = new Staff();
            default -> throw  new RuntimeException("Failed registration user, Invalid User");
        }
        return user;
    }

    private void mapToNewUser(User user, User child) {
        child.setUsername(user.getUsername());
        user.setUserPhoneNumber(user.getUserPhoneNumber());
        child.setEmail(user.getEmail());
        child.setUserRole(user.getUserRole());
        child.setPassword(user.getPassword());
    }
}
