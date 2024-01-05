package com.example.team3_kakaotalk.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

public class UserResponse {
    @Data
    @ToString
    public static class loginDTO{
        private int id;
        private String nickname;
        private String password;
        private String jwt;

        public loginDTO(User user) {
            this.id = user.getId();
            this.nickname = user.getNickname();
            this.password = user.getPassword();
            this.jwt = jwt;
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
}
