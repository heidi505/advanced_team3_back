package com.example.team3_kakaotalk.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMBRepository {
	
	// 친구 탭 메인
	public List<UserResponse.FriendTepMainResponseDTO> findByFriendTepMain(Integer id);
	
	// 나의 프로필 수정 및 삭제
	public UserRequest.MyProfileUpdateRequestDTO myProfileUpdate(UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto);

	// 나의 프로필 상세보기
	public UserResponse.MyProfileDetailResponseDTO findByMyProfileDetail(Integer id);
	
	// 친구 프로필 상세보기
	public UserResponse.FriendProfileDetailResponseDTO findByFriendProfileDetail(Integer id);
	
	// 연락처로 친구 추가
	public void phoneNumFriendAdd();

	// 이메일로 친구 추가
	public void emailFriendAdd();


}
