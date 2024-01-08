package com.example.team3_kakaotalk.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.team3_kakaotalk._core.handler.exception.MyBadRequestException;
import com.example.team3_kakaotalk._core.handler.exception.MyServerErrorException;
import com.example.team3_kakaotalk._core.handler.exception.MyUnAuthorizedException;
import com.example.team3_kakaotalk._core.utils.JwtTokenUtils;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private UserMBRepository userMBRepository;
    

    @Autowired
    private HttpSession httpSession;

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

        Optional<User> userOptional = userJPARepository.findByEmail(loginDTO.getEmail());
        User user = userOptional.orElseThrow(() -> new MyBadRequestException("유저 없음"));
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
    
    // 나의 프로필 수정 및 삭제
    public UserRequest.MyProfileUpdateRequestDTO myProfileUpdate(UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto){	
    	UserRequest.MyProfileUpdateRequestDTO myProfileUpdate = this.myProfileUpdate(myProfileUpdateRequestDto);
    	return myProfileUpdate;
    }
    

@Transactional
    public UserResponse.UpdateResponseDTO update(UserRequest.UpdateDTO updateDTO,  User sessionUser) {

        User user = userJPARepository.findById(sessionUser.getId())
                .orElseThrow(() -> new MyBadRequestException("오류 : " + updateDTO.getPhoneNum()));

        System.out.println(updateDTO.getEmail());
        System.out.println(sessionUser.getPhoneNum());
        if (!(updateDTO.getEmail().equals(sessionUser.getEmail()))) {
            throw new MyUnAuthorizedException("로그인 유저랑 변경하려는 유저가 다름 : " + updateDTO.getEmail());
        }

        user.setPassword(updateDTO.getPassword());
        user.setPassword(updateDTO.getPhoneNum());


        UserResponse.UpdateResponseDTO responseDTO = new UserResponse.UpdateResponseDTO(user);

        return responseDTO;
    }


    // 나의 프로필 상세보기
    public UserResponse.MyProfileDetailResponseDTO myProfileDetail(Integer id){
    	UserResponse.MyProfileDetailResponseDTO myProfileDetail = this.userMBRepository.findByMyProfileDetail(id);
    	return myProfileDetail;
    }
   
    

    //친구 프로필 상세보기
    public UserResponse.FriendProfileDetailResponseDTO friendProfileDetail(Integer id){
    	UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userMBRepository.findByFriendProfileDetail(id);
    	return friendProfileDetailResponseDto;
    }


}
