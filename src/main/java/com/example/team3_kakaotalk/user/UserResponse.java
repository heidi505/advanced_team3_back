package com.example.team3_kakaotalk.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

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

    @Getter
    @Setter
    @ToString
    public static class UpdateResponseDTO {
        private int id;
        private String password;
        private String phoneNum;



        public UpdateResponseDTO(User user) {
            this.id = user.getId();
            this.password = user.getPassword();
            this.phoneNum = user.getPhoneNum();


        }
    }


}
