package com.exmaple.dio.controller;

import com.exmaple.dio.model.User;
import com.exmaple.dio.service.UserService;
import com.exmaple.dio.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        user = userService.registerUser(user);
        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("User Created");
        structure.setData(user);
        return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
    }

}
