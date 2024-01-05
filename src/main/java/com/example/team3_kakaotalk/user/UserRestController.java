package com.example.team3_kakaotalk.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.team3_kakaotalk._core.utils.ApiUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserRestController {

	// 친구탭 메인 화면
	@GetMapping("/friend-tep-main")
	public ResponseEntity<?> friendTepMain(){
		
		
		
		
		
		return ResponseEntity.ok().body(ApiUtils.success(null));
	}
	
	
	
}
