package com.example.exam.service;


import com.example.exam.model.entity.Ship;
import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserServiceModel;

import java.util.List;


public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUserNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);



}
