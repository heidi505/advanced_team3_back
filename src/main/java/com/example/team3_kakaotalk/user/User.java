package com.example.team3_kakaotalk.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_tb")
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String phoneNum;
    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public User(int id, String username, String nickname, String password, String phoneNum, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.phoneNum = phoneNum;
        this.createdAt = createdAt;
    }
}
