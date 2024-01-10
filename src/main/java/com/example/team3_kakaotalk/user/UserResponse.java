package com.example.team3_kakaotalk.user;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

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
        private int id;
        private String phoneNum;

        public UpdateResponseDTO(User user) {
            this.id = user.getId();
            this.phoneNum = user.getPhoneNum();

        }
    }

    // 친구 탭 메인
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FriendTepMainResponseDTO {
        private int id;
        private String nickname;
        private String profileImage;
        private String birthdate;
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


}

