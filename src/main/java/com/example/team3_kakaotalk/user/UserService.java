package com.example.team3_kakaotalk.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.team3_kakaotalk.profile.Profile;
import com.example.team3_kakaotalk.profile.ProfileJPARepository;
import com.sun.tools.javac.Main;
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
    private ProfileJPARepository profileJPARepository;


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
    public UserResponse.MainResponseDTO friendTepMain(Integer id){

        Profile profile = profileJPARepository.findByUserId(id);

        UserResponse.MainResponseDTO mainDTO = new UserResponse.MainResponseDTO();
        mainDTO.setUserId(id);
        mainDTO.setUserProfile(profile);

    	List<UserResponse.FriendTepMainResponseDTO> friendLists = this.userMBRepository.findByFriendTepMain(id);
        mainDTO.setFriendList(friendLists);

        List<UserResponse.FriendTepMainResponseDTO> birthdayFriendLists = friendLists.stream()
                        .filter(e->e.getIsBirthday().equals("오늘 생일 친구"))
                        .collect(Collectors.toList());

        mainDTO.setBirthdayFriendList(birthdayFriendLists);
        mainDTO.setBirthdayCount(birthdayFriendLists.size());

    	return mainDTO;
    }


    @Transactional
    public UserResponse.UpdateResponseDTO update(UserRequest.UpdateDTO updateDTO, User sessionUser) {
          userJPARepository.updatePhoneNumById(sessionUser.getEmail(), sessionUser.getPhoneNum());

        User user = userJPARepository.findById(sessionUser.getId())
                .orElseThrow(() -> new MyBadRequestException("오류 : " + sessionUser.getEmail()));

//        if (!(updateDTO.getEmail().equals(sessionUser.getEmail()))) {
//            throw new MyUnAuthorizedException("로그인 유저랑 변경하려는 유저가 다름 : " + updateDTO.getEmail());
//        }
        if (updateDTO.getPhoneNum() == null || (updateDTO.getPhoneNum().isEmpty())){
            throw  new MyUnAuthorizedException("로그인 유저랑 변경하려는 유저가 다름 ");
        }

        // 변경된 내용 업데이트
        user.setPhoneNum(updateDTO.getPhoneNum());

        UserResponse.UpdateResponseDTO responseDTO = new UserResponse.UpdateResponseDTO(user);
        return responseDTO;
    }

    // 나의 프로필 상세보기
    public UserResponse.MyProfileDetailResponseDTO myProfileDetail(Integer id){
    	UserResponse.MyProfileDetailResponseDTO myProfileDetailResponseDto = this.userMBRepository.findByMyProfileDetail(id);
    	return myProfileDetailResponseDto;
    }

    // 친구 프로필 상세보기
    public UserResponse.FriendProfileDetailResponseDTO friendProfileDetail(Integer id){
    	UserResponse.FriendProfileDetailResponseDTO friendProfileDetailResponseDto = this.userMBRepository.findByFriendProfileDetail(id);
    	return friendProfileDetailResponseDto;
    }
    
    // 나의 프로필 수정
    public void myProfileUpdate(UserRequest.MyProfileUpdateRequestDTO myProfileUpdateRequestDto){
        this.userMBRepository.myProfileNicknameUpdate(myProfileUpdateRequestDto);
        this.userMBRepository.myProfileSmessageAndPimageAndBimageUpdate(myProfileUpdateRequestDto);
    }

    // 연락처로 친구 추가
    public void phoneNumFriendAdd(UserRequest.PhoneNumFriendAddRequestDTO phoneNumFriendAddRequestDto){
        String userPhoneNum = this.userMBRepository.findByPhoneNum(phoneNumFriendAddRequestDto.getPhoneNum());
        UserResponse.PhoneNumFriendAddResponseDTO PhoneNumFriendAddResponseDTO = this.userMBRepository.findByPhoneNumFriendAdd(phoneNumFriendAddRequestDto);
        if(phoneNumFriendAddRequestDto.getPhoneNum() == null || phoneNumFriendAddRequestDto.getPhoneNum().isEmpty()){
            throw new MyBadRequestException("전화번호를 입력해 주세요.");
        }
        if(userPhoneNum == null){
            throw new MyBadRequestException("등록되지 않은 사용자입니다.");
        }
        if(PhoneNumFriendAddResponseDTO != null){
            throw new MyBadRequestException("이미 친구등록된 전화번호입니다.");
        }
        this.userMBRepository.phoneNumFriendAdd(phoneNumFriendAddRequestDto);
    }

    // 이메일로 친구 추가
    public void emailFriendAdd(UserRequest.EmailFriendAddRequestDTO emailFriendAddRequestDto){
        String userEmail = this.userMBRepository.findByEmail(emailFriendAddRequestDto.getEmail());
        UserResponse.EmailFriendAddResponseDTO emailFriendAddResponseDto = this.userMBRepository.findByEmailFriendAdd(emailFriendAddRequestDto);
        if(emailFriendAddRequestDto.getEmail() == null || emailFriendAddRequestDto.getEmail().isEmpty()){
            throw new MyBadRequestException("이메일을 입력하세요.");
        }
        if(userEmail == null){
            throw new MyBadRequestException("등록되지 않은 사용자입니다.");
        }
        if(emailFriendAddResponseDto != null){
            throw new MyBadRequestException("이미 친구등록된 이메일입니다.");
        }
        this.userMBRepository.emailFriendAdd(emailFriendAddRequestDto);
    }

    // 나의 프로필 삭제(프로필 이미지)
    public void myProfileImageDelete(Integer id){
        this.userMBRepository.myProfileImageDelete(id);
    }

    // 나의 프로필 삭제(배경 이미지)
    public void myProfileBackImageDelete(Integer id){
        this.userMBRepository.myProfileBackImageDelete(id);
    }

    public UserResponse.loginDTO autoLogin(User sessionUser) {
        User user = userJPARepository.findById(sessionUser.getId()).orElseThrow(()->new MyBadRequestException("자동 로그인 오류"));

        String jwt = JwtTokenUtils.create(user);

        UserResponse.loginDTO dto = new UserResponse.loginDTO(user);
        dto.setJwt(jwt);

        return dto;

    }


    public UserResponse.UserTestDTO userTest(int userId) {
        Optional<User> user = userJPARepository.findById(userId);

        UserResponse.UserTestDTO dto = new UserResponse.UserTestDTO(user.get());

        return dto;

    }

    public List<UserResponse.UserTestDTO> ListTest() {
        List<User> user = userJPARepository.findAll();

        List<UserResponse.UserTestDTO> newList = user.stream().map(e->new UserResponse.UserTestDTO(e)).collect(Collectors.toList());

        return newList;
    }
}
