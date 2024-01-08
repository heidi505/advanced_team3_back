package com.example.team3_kakaotalk.user;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.team3_kakaotalk._core.handler.exception.MyBadRequestException;
import com.example.team3_kakaotalk._core.utils.ApiUtils;


import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	// 친구탭 메인 화면
	@GetMapping("/friend-tep-main/{id}")
	public ResponseEntity<?> friendTepMain(@PathVariable int id){
		List<UserResponse.FriendTepMainResponseDTO> friendTepMain = this.userService.friendTepMain(id);
		return ResponseEntity.ok().body(ApiUtils.success(friendTepMain));
	}

	// 나의 프로필 상세보기
	@GetMapping("/my-profile-detail/{id}")
	public ResponseEntity<?> myProfileDetail(@PathVariable Integer id){
		UserResponse.MyProfileDetailResponseDTO myProfileDetail = this.userService.myProfileDetail(id);
		return ResponseEntity.ok().body(ApiUtils.success(myProfileDetail));
	}

	// 친구 프로필 상세보기
	@GetMapping("/friend-profile-detail/{id}")
	public ResponseEntity<?> friendProfileDetail(@PathVariable int id){
		UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userService.friendProfileDetail(id);
		return ResponseEntity.ok().body(ApiUtils.success(friendProfileDetailResponseDto));
	}

	// 나의 프로필 수정 및 삭제
	@PostMapping("/my-profile-update")
	public ResponseEntity<?> myProfileUpdate(@RequestBody UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto){
//		MultipartFile file = myProfileUpdateRequestDto.getFile();
//		if(file.isEmpty() == false) {
//			// 파일 사이즈 체크
//			if(file.getSize() > Define.MAX_FILE_SIZE) {
//				throw new MyBadRequestException("파일 크기는 20MB 이상 클 수 없습니다.");
//			}
//		}
		this.userService.myProfileUpdate(myProfileUpdateRequestDto);
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}


		
}
