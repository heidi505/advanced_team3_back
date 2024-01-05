package com.example.team3_kakaotalk.user.response;

import java.sql.Date;

import lombok.Data;

@Data	
public class FriendTepMainrResponseDTO {

	private Integer userId;
	private String userName;
	private String profileImage;
	private Date birthdate;
	
}
