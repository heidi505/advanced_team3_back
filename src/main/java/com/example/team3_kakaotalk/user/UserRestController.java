package com.example.team3_kakaotalk.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> friendTepMain(@PathVariable Integer id) {

        System.out.println("================");
        System.out.println("메인 통신 중 컨트롤러 호출");

        UserResponse.MainResponseDTO dto = this.userService.friendTepMain(id);
        return ResponseEntity.ok().body(ApiUtils.success(dto));
    }

    // 나의 프로필 상세보기
    @GetMapping("/my-profile-detail/{id}")
    public ResponseEntity<?> myProfileDetail(@PathVariable Integer id) {
        System.out.println("디테일 컨트롤러 진입 : " + id);
        UserResponse.MyProfileDetailResponseDTO myProfileDetail = this.userService.myProfileDetail(id);
        return ResponseEntity.ok().body(ApiUtils.success(myProfileDetail));
    }

    // 친구 프로필 상세보기
    @GetMapping("/friend-profile-detail/{id}")
    public ResponseEntity<?> friendProfileDetail(@PathVariable Integer id) {
        UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userService.friendProfileDetail(id);
        return ResponseEntity.ok().body(ApiUtils.success(friendProfileDetailResponseDto));
    }

    // 연락처로 친구 추가
    @PostMapping("/phoneNum-friend-add")
    public ResponseEntity<?> phoneNumFriendAdd(@RequestBody UserRequest.PhoneNumFriendAddRequestDTO phoneNumFriendAddRequestDto) {
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
    public ResponseEntity<?> myProfileUpdate(@RequestBody UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto) {
        this.userService.myProfileUpdate(myProfileUpdateRequestDto);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 나의 프로필 삭제(프로필 이미지)
    @GetMapping("/my-profileImage-delete/{id}")
    public ResponseEntity<?> myProfileImageDelete(@PathVariable Integer id) {
        this.userService.myProfileImageDelete(id);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 나의 프로필 삭제(배경 이미지)
    @GetMapping("/my-profileBackImage-delete/{id}")
    public ResponseEntity<?> myProfileBackImageDelete(@PathVariable Integer id) {
        this.userService.myProfileBackImageDelete(id);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
