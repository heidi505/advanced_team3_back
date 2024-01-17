package com.example.team3_kakaotalk.user;
import com.example.team3_kakaotalk.profile.Profile;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserResponse {
    @Data
    @ToString
    public static class loginDTO {
        private int id;
        private String nickname;
        private String phoneNum;
        private String email;
        private String jwt;

        public loginDTO(User user) {
            this.id = user.getId();
            this.nickname = user.getNickname();
            this.phoneNum = user.getPhoneNum();
            this.email = user.getEmail();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class UpdateResponseDTO {
        //phoneNum만 필요!
        private String newPhoneNum;

        public UpdateResponseDTO(User user) {
            this.newPhoneNum = user.getPhoneNum();

        }
    }


    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainResponseDTO{
        private int userId;
        private Profile userProfile;
        private List<FriendTepMainResponseDTO> friendList;
        private List<FriendTepMainResponseDTO> birthdayFriendList;
        private int birthdayCount;
    }

    // 친구 탭 메인
    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FriendTepMainResponseDTO {
        private Integer userId;
        private String nickname;
        private String birthdate;
        private String profileImage;
        private String backImage;
        private String statusMessage;
        private String phoneNum;
        private String isBirthday;
        private boolean isFavorite;
    }

    // 나의 프로필 상세보기
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyProfileDetailResponseDTO {
        private int id;
        private String nickname;
        private String profileImage;
        private String backImage;
        private String statusMessage;
    }

    // 친구 프로필 상세보기
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FriendProfileDetailResponseDTO {
        private int id;
        private String nickname;
        private String profileImage;
        private String backImage;
        private String statusMessage;
    }

    // 나의 프로필 삭제(프로필 이미지)
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyProfileImageDeleteResponseDTO {
        private Integer id;
        private String profileImage;
    }

    // 나의 프로필 삭제(배경 이미지)
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyProfileBackImageDeleteResponseDTO {
        private Integer id;
        private String backImage;
    }

    // 연락처로 친구 추가
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneNumFriendAddResponseDTO{
        private Integer userId1;
        private Integer userId2;
        private String phoneNum;
    }

    // 이메일로 친구 추가
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmailFriendAddResponseDTO{
        private Integer userId1;
        private Integer userId2;
        private String email;
    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserTestDTO{
        int userId;
        String userNickName;
        String userPhoneNum;

        public UserTestDTO(User user) {
            this.userId = user.getId();
            this.userNickName = user.getNickname();
            this.userPhoneNum = user.getPhoneNum();
        }
    }



}




