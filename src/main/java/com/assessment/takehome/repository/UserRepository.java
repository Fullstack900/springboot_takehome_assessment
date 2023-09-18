package com.assessment.takehome.repository;

import com.assessment.takehome.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE lower(u.email) LIKE lower(concat('%', ?1, '%')) AND u.phoneNumber LIKE %?2%")
    List<User> findAllByEmailOrPhoneNumber(String email, String phoneNumber);
}
