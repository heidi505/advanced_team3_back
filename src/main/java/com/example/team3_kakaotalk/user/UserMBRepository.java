package com.example.team3_kakaotalk.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMBRepository {
	
	public List<UserResponse.FriendTepMainResponseDTO> findByFriendTepMain(Integer id);
	
	// 친구 프로필 상세보기
	public UserResponse.FriendProfileDetailResponseDTO findByFriendProfileDetail(Integer id);

}
