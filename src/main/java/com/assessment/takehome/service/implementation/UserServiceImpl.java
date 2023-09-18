package com.assessment.takehome.service.implementation;

import com.assessment.takehome.entity.User;
import com.assessment.takehome.model.req.UserRequest;
import com.assessment.takehome.repository.UserRepository;
import com.assessment.takehome.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers(String email, String phoneNumber) {
        return userRepository.findAllByEmailOrPhoneNumber(email, phoneNumber);
    }

    @Override
    public User saveUser(UserRequest userRequest) {
        return userRepository.save(userRequest.toUser());
    }

    @Override
    public User updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null) {
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setEmail(userRequest.getEmail());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setDob(userRequest.getDob());
            user.setAddress(userRequest.getAddress());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.delete(user);
            return user;
        } else {
            return null;
        }
    }
}
