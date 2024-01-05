package com.example.team3_kakaotalk.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    Optional<User> findByPhoneNum(String phoneNum);

    Optional<User> findById(Integer userId);
}