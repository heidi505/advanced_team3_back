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

	// 나의 프로필 수정(이름)
	public void myProfileNicknameUpdate(UserRequest.MyProfileUpdateRequestDTO MyProfileUpdateRequestDto);

	// 나의 프로필 수정(상태 메세지, 프로필 이미지, 배경 이미지)
	public void myProfileSmessageAndPimageAndBimageUpdate(UserRequest.MyProfileUpdateRequestDTO MyProfileUpdateRequestDto);

	// 나의 프로필 삭제
	public void myProfileDelete(Integer id);

}
