package com.assessment.takehome.model.res;

import com.assessment.takehome.entity.User;

import java.util.List;

public class UserListResponse extends BaseResponse {
    private List<User> users;

    public UserListResponse() {
        super();
    }

    public UserListResponse(String message, Boolean status, List<User> users) {
        super(message, status);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserListResponse{" +
                "users:" + users +
                '}';
    }
}
