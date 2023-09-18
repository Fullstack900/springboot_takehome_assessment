package com.assessment.takehome.controller;

import com.assessment.takehome.constants.HttpStatus;
import com.assessment.takehome.constants.ResponseMessage;
import com.assessment.takehome.entity.User;
import com.assessment.takehome.model.req.UserRequest;
import com.assessment.takehome.model.res.UserListResponse;
import com.assessment.takehome.model.res.UserResponse;
import com.assessment.takehome.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<UserListResponse> getUser(
            @RequestParam(required = false, defaultValue = "") String email,
            @RequestParam(required = false, defaultValue = "") String phoneNumber
    ) {
        return ResponseEntity.ok(new UserListResponse(ResponseMessage.SUCCESS, HttpStatus.SUCCESS, userService.getUsers(email, phoneNumber)));
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> postUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(new UserResponse(ResponseMessage.USER_SAVE_SUCCESS, HttpStatus.SUCCESS, userService.saveUser(userRequest)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUseer(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        if (id == null)
            return ResponseEntity.ok(new UserResponse(ResponseMessage.USER_ID_REQUIRED, HttpStatus.ERROR, null));

        User user = userService.updateUser(id, userRequest);
        if (user == null) {
            return ResponseEntity.ok(new UserResponse(ResponseMessage.NOT_FOUND, HttpStatus.ERROR, null));
        }
        return ResponseEntity.ok(new UserResponse(ResponseMessage.USER_UPDATE_SUCCESS, HttpStatus.SUCCESS, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.ok(new UserResponse(ResponseMessage.USER_ID_REQUIRED, HttpStatus.ERROR, null));

        User user = userService.deleteUser(id);
        if (user == null) {
            return ResponseEntity.ok(new UserResponse(ResponseMessage.NOT_FOUND, HttpStatus.ERROR, null));
        }
        return ResponseEntity.ok(new UserResponse(ResponseMessage.USER_DELETE_SUCCESS, HttpStatus.SUCCESS, user));
    }
}
