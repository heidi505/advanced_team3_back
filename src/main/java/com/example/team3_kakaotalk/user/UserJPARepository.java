package com.example.team3_kakaotalk.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.team3_kakaotalk.user.UserResponse.FriendTepMainResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {

    Optional<User> findByNickname(String nickname);

    

	List<FriendTepMainResponseDTO> findAllById(int id);
    

}
