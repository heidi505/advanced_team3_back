package com.example.team3_kakaotalk.user;

import lombok.Data;
import lombok.ToString;

public class UserResponse {
    @Data
    @ToString
    public static class loginDTO{
        private int id;
        private String username;
        private String nickname;
        private String password;
        private String jwt;

        public loginDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }

    }

    @Data
    @ToString
    public static class TestDTO{
        private int id;
        private String jwt;
        private String username;
    }
}
