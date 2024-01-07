package com.example.team3_kakaotalk.user;

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
        private String password;
        private String phoneNum;
        private String jwt;

        public loginDTO(User user) {
            this.id = user.getId();
            this.nickname = user.getNickname();
            this.password = user.getPassword();
            this.phoneNum = user.getPhoneNum();
        }
    }

    @Data
    @ToString
    public static class TestDTO{
        private int userId;
        private String userEmail;
        private String userPhoneNum;
        private String gender;
        private Date birthdate;
        private Timestamp createdAt;
        private int profileId;
    }
    
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FriendTepMainResponseDTO{
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
    public static class MyProfileDetailResponseDTO{
    	private int id;
    	private String nickname;
    	private String profileImage;
    }
    

}
