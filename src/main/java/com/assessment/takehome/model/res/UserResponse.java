package com.assessment.takehome.model.res;

import com.assessment.takehome.entity.User;

public class UserResponse extends BaseResponse {
    private User users;

    public UserResponse() {
        super();
    }

    public UserResponse(String message, Boolean status, User users) {
        super(message, status);
        this.users = users;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListResponse{" +
                "users:" + users +
                '}';
    }
}
