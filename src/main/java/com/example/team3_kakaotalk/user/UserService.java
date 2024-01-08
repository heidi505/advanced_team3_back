package com.example.team3_kakaotalk.user;

import com.example.team3_kakaotalk._core.handler.exception.MyBadRequestException;
import com.example.team3_kakaotalk._core.handler.exception.MyServerErrorException;
import com.example.team3_kakaotalk._core.utils.JwtTokenUtils;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private UserMBRepository userMBRepository;
    

    @Transactional
    public void join(UserRequest.JoinDTO joinDTO) {
        try {
            User user = joinDTO.toEntity();
            userJPARepository.save(user);
        }catch (Exception e){
            throw new MyServerErrorException("서버 에러");
        }
    }

    public UserResponse.loginDTO login(UserRequest.LoginDTO loginDTO) {

        User user = userJPARepository.findByPhoneNum(loginDTO.getPhoneNum()).orElseThrow(()->new MyBadRequestException("유저 없음"));
        //이걸 기반으로 디비에서 조회
        String jwt = JwtTokenUtils.create(user);
        //JWT 생성
        UserResponse.loginDTO responseDTO = new UserResponse.loginDTO(user);
        responseDTO.setJwt(jwt);
        ///JWT 보내줌
        return responseDTO;
    }
    
    // 친구탭 메인 화면
    public List<UserResponse.FriendTepMainResponseDTO> friendTepMain(Integer id){
    	List<UserResponse.FriendTepMainResponseDTO> dtolists = this.userMBRepository.findByFriendTepMain(id);
    	return dtolists;
    }
    
    // 친구 프로필 상세보기
    public UserResponse.FriendProfileDetailResponseDTO friendProfileDetail(Integer id){
    	UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userMBRepository.findByFriendProfileDetail(id);
    	return friendProfileDetailResponseDto;
    }
    
    
}
