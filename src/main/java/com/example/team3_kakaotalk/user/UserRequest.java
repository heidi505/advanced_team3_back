package com.example.team3_kakaotalk.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.sql.Timestamp;

public class UserRequest {
    @Data
    @ToString
    public static class JoinDTO{

        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;


        private String nickname;
     
        @Size(min = 4, max = 20, message = "4에서 20자 이내여야 합니다.")
        private String password;
        private String phoneNum;
        private Date birthdate;

        public User toEntity(){
            return User.builder()
                    .email(email)
                    .nickname(nickname)
                    .password(password)
                    .phoneNum(phoneNum)
                    .birthdate(birthdate)
                    .build();

        }
    }

    @Data
    @ToString

    public  static  class LoginDTO{

//        @NotEmpty
//        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;

        private String PhoneNum;
//        @NotEmpty
//        @Size(min = 4, max = 20, message = "4에서 20자 이내여야 합니다.")
        private String password;
    }

    // 나의 프로필 수정
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyProfileUpdateRequestDTO{
    	private Integer id;
    	private String nickname;
    	private String statusMessage;
    	private MultipartFile file;
    	private String originFileName;
    	private String profileImage;
    	private String backImage;
    }
    


}
