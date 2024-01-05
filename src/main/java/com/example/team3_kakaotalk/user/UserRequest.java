package com.example.team3_kakaotalk.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserRequest {
    @Data
    @ToString
    public static class JoinDTO{
        private String username;
        private String nickname;
        private String password;

        public User toEntity(){
            return User.builder()
                    .nickname(nickname)
                    .password(password)
                    .build();
        }
    }

    @Data
    @ToString
    public static class LoginDTO{
        private String nickname;
    }
}
