package com.example.team3_kakaotalk.profile;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Entity
@Table(name = "profile_tb")
@ToString
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String profileImage;
    private String statusMessage;
    private String BackImage;
    private String qrCode;
    private Integer userId;



    @Builder
    public Profile(Integer id, String profileImage, String statusMessage, String backImage, String qrCode, Integer userId) {
        this.id = id;
        this.profileImage = profileImage;
        this.statusMessage = statusMessage;
        BackImage = backImage;
        this.qrCode = qrCode;
        this.userId = userId;
    }
}
