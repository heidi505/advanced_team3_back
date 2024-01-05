package com.example.team3_kakaotalk.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMBRepository {
	
	public List<UserResponse.FriendTepMainResponseDTO> findByFriendTepMain(Integer id);

}
