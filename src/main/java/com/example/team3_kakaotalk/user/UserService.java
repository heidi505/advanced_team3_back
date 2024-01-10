package com.example.team3_kakaotalk.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder passwordEncoder;
    

    @Autowired
    private HttpSession httpSession;

    @Transactional
    public void join(UserRequest.JoinDTO joinDTO) {
        System.out.println("+++++++++join서비스 시작+++++++ : " + joinDTO.getEmail());
        try {
            //비밀번호 해시화
            String encodedPassword = passwordEncoder.encode(joinDTO.getPassword());
            //해시화된 비밀번호 설정
            joinDTO.setPassword(encodedPassword);
            System.out.println("++++++ 해시화된 비번 ++++++ : "+ encodedPassword);

            User user = joinDTO.toEntity();
            userJPARepository.save(user);
        } catch (Exception e) {
            throw new MyServerErrorException("서버 에러");
        }
    }


    public UserResponse.loginDTO login(UserRequest.LoginDTO loginDTO) {

        //이메일, 비번으로 조회
        Optional<User> userOptional = userJPARepository.findByEmail(loginDTO.getEmail());
        User user = userOptional.get();

        // 사용자 정보가 존재하고, 입력된 비밀번호와 저장된 해시된 비밀번호가 일치하는지 확인
        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            // 비밀번호가 일치하면 JWT 생성 및 응답 DTO 생성
            String jwt = JwtTokenUtils.create(user);
            UserResponse.loginDTO responseDTO = new UserResponse.loginDTO(user);
            responseDTO.setJwt(jwt);
            return responseDTO;
        } else {
            // 사용자 정보가 없거나 비밀번호가 일치하지 않으면 예외 발생
            throw new MyBadRequestException("유저 없음");
        }
    }

    public void resetPassword(String email){
        Optional<User> userOptional = userJPARepository.findByEmail(email);
        User user = userOptional.orElseThrow(()-> new MyBadRequestException("해당 이메일을 찾을 수 없습니다."));

    }


    
    // 친구탭 메인 화면
    public List<UserResponse.FriendTepMainResponseDTO> friendTepMain(Integer id){
    	List<UserResponse.FriendTepMainResponseDTO> dtolists = this.userMBRepository.findByFriendTepMain(id);
    	return dtolists;
    }

@Transactional
    public UserResponse.UpdateResponseDTO update(UserRequest.UpdateDTO updateDTO,  User sessionUser) {

        User user = userJPARepository.findById(sessionUser.getId())
                .orElseThrow(() -> new MyBadRequestException("오류 : " + updateDTO.getPhoneNum()));

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
    
    // 나의 프로필 수정
    public void myProfileUpdate(UserRequest.MyProfileUpdateRequestDTO MyProfileUpdateRequestDto){
        this.userMBRepository.myProfileNicknameUpdate(MyProfileUpdateRequestDto);
        this.userMBRepository.myProfileSmessageAndPimageAndBimageUpdate(MyProfileUpdateRequestDto);
    }

    // 나의 프로필 삭제
    public void myProfileDelete(Integer id){
        this.userMBRepository.myProfileDelete(id);
    }

    public UserResponse.loginDTO autoLogin(User sessionUser) {
        User user = userJPARepository.findById(sessionUser.getId()).orElseThrow(()->new MyBadRequestException("자동 로그인 오류"));

        String jwt = JwtTokenUtils.create(user);

        UserResponse.loginDTO dto = new UserResponse.loginDTO(user);
        dto.setJwt(jwt);

        return dto;

    }


}
