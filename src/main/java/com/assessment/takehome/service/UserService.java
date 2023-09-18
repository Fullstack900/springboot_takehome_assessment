package com.assessment.takehome.service;

import com.assessment.takehome.entity.User;
import com.assessment.takehome.model.req.UserRequest;

import java.util.List;

public interface UserService {
    List<User> getUsers(String email, String phoneNumber);

    User saveUser(UserRequest userRequest);

    User updateUser(Long id, UserRequest userRequest);

    User deleteUser(Long id);
}
