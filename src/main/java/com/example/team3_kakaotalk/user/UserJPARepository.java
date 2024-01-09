package com.example.team3_kakaotalk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team3_kakaotalk.user.UserResponse.FriendTepMainResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);


	List<FriendTepMainResponseDTO> findAllById(int id);

    Optional<User> findByPhoneNum(String phoneNum);

    Optional<User> findById(Integer userId);
}



