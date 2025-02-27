package com.exmaple.dio.service.impl;

import com.exmaple.dio.model.User;
import com.exmaple.dio.repository.UserRepository;
import com.exmaple.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User registerUser(User user) {

        return userRepository.save(user);
    }
}
