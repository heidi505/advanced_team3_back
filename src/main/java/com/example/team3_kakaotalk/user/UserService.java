package com.example.team3_kakaotalk.user;

import com.example.team3_kakaotalk._core.handler.exception.MyBadRequestException;
import com.example.team3_kakaotalk._core.handler.exception.MyServerErrorException;
import com.example.team3_kakaotalk._core.handler.exception.MyUnAuthorizedException;
import com.example.team3_kakaotalk._core.utils.JwtTokenUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;

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

        User user = userJPARepository.findByPhoneNum(loginDTO.getPhoneNum()).orElseThrow(()->new MyBadRequestException("유저 없음"));
        //이걸 기반으로 디비에서 조회
        String jwt = JwtTokenUtils.create(user);
        //JWT 생성
        UserResponse.loginDTO responseDTO = new UserResponse.loginDTO(user);
        responseDTO.setJwt(jwt);
        ///JWT 보내줌
        return responseDTO;
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

        user.setEmail(updateDTO.getEmail());
        user.setPassword(updateDTO.getPhoneNum());


        UserResponse.UpdateResponseDTO responseDTO = new UserResponse.UpdateResponseDTO(user);

        return responseDTO;
    }



}
