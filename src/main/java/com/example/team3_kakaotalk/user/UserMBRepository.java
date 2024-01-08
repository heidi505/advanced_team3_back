package com.example.team3_kakaotalk.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMBRepository {

	// 친구탭 메인 화면
	public List<UserResponse.FriendTepMainResponseDTO> findByFriendTepMain(Integer id);

	// 나의 프로필 상세보기
	public UserResponse.MyProfileDetailResponseDTO findByMyProfileDetail(Integer id);

	// 친구 프로필 상세보기
	public UserResponse.FriendProfileDetailResponseDTO findByFriendProfileDetail(Integer id);

	// 나의 프로필 수정 및 삭제
	public void myProfileUpdate(UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto);


}
