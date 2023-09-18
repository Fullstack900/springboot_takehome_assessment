package com.assessment.takehome.model.req;

import com.assessment.takehome.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dob;
    private String address;

    public User toUser() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setDob(LocalDate.parse(dob));
        user.setAddress(address);
        return user;
    }

    public LocalDate getDob() {
        return LocalDate.parse(dob);
    }
}
