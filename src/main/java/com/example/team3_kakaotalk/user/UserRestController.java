package com.example.team3_kakaotalk.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team3_kakaotalk._core.utils.ApiUtils;

@RestController
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
	
	
		
}
