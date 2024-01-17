package com.example.team3_kakaotalk.user;

import java.util.List;

import com.example.team3_kakaotalk.friend.Friend;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team3_kakaotalk._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	// 친구탭 메인 화면
	@GetMapping("/friend-tep-main/{id}")
	public ResponseEntity<?> friendTepMain(@PathVariable Integer id){

		System.out.println("================");
		System.out.println("메인 통신 중 컨트롤러 호출");

		UserResponse.MainResponseDTO dto = this.userService.friendTepMain(id);
		return ResponseEntity.ok().body(ApiUtils.success(dto));
	}

	// 나의 프로필 상세보기
	@GetMapping("/my-profile-detail/{id}")
	public ResponseEntity<?> myProfileDetail(@PathVariable Integer id){
		System.out.println("디테일 컨트롤러 진입 : " + id);
		UserResponse.MyProfileDetailResponseDTO myProfileDetail = this.userService.myProfileDetail(id);
		return ResponseEntity.ok().body(ApiUtils.success(myProfileDetail));
	}

	// 친구 프로필 상세보기
	@GetMapping("/friend-profile-detail/{id}")
	public ResponseEntity<?> friendProfileDetail(@PathVariable Integer id){
		UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userService.friendProfileDetail(id);
		return ResponseEntity.ok().body(ApiUtils.success(friendProfileDetailResponseDto));
	}

	// 연락처로 친구 추가
	@PostMapping("/phoneNum-friend-add")
	public ResponseEntity<?> phoneNumFriendAdd(@RequestBody UserRequest.PhoneNumFriendAddRequestDTO phoneNumFriendAddRequestDto){
		this.userService.phoneNumFriendAdd(phoneNumFriendAddRequestDto);
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}

	// 이메일로 친구 추가
	@PostMapping("/email-friend-add")
	public ResponseEntity<?> emailFriendAdd(@RequestBody UserRequest.EmailFriendAddRequestDTO emailFriendAddRequestDto) {
		this.userService.emailFriendAdd(emailFriendAddRequestDto);
		return ResponseEntity.ok().body(ApiUtils.success(null));
    }

	// 나의 프로필 수정
	@PostMapping("/my-profile-update")
	public ResponseEntity<?> myProfileUpdate(@RequestBody UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto){
		// User sessionUser = (User) session.getAttribute("sessionUser");
		//System.out.println("세션 유저 정보 확인 : " + sessionUser.toString());
		System.out.println("컨트롤러 진입 확인 : " + myProfileUpdateRequestDto.getNickname());
		UserResponse.MyProfileUpdateResponseDTO myProfileUpdateResponseDto = this.userService.myProfileUpdate(myProfileUpdateRequestDto);

		System.out.println("프론트로 보내기 전 : " + myProfileUpdateRequestDto.getNickname());
		return ResponseEntity.ok().body(ApiUtils.success(myProfileUpdateResponseDto));
	}

	// 나의 프로필 삭제(프로필 이미지)
	@GetMapping("/my-profileImage-delete/{id}")
	public ResponseEntity<?> myProfileImageDelete(@PathVariable Integer id){
		this.userService.myProfileImageDelete(id);
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}

	// 나의 프로필 삭제(배경 이미지)
	@GetMapping("/my-profileBackImage-delete/{id}")
	public ResponseEntity<?> myProfileBackImageDelete(@PathVariable Integer id){
		this.userService.myProfileBackImageDelete(id);
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}

	// 친구 차단
	@GetMapping("/friend-delete/{id}")
	public ResponseEntity<?> friendDelete(@PathVariable Integer id){
		this.userService.friendDelete(id);
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}

	// 친구 검색
	@PostMapping("/search-friend")
	public ResponseEntity<?> searchFriend(@RequestBody UserRequest.SearchFriendRequestDTO searchFriendRequestDto){
		System.out.println("여기 아이디------------------------"+searchFriendRequestDto.getId());
		System.out.println("여기 키워드------------------------"+searchFriendRequestDto.getKeyword());
		Integer friendCount = this.userService.friendCount(searchFriendRequestDto.getId());
		UserResponse.SearchFriendResponseDTO searchFriendResponseDto = this.userService.searchFriend(searchFriendRequestDto, friendCount);
		return ResponseEntity.ok().body(ApiUtils.success(searchFriendResponseDto));
	}


}
