package com.example.team3_kakaotalk.auth;

import com.example.team3_kakaotalk._core.utils.ApiUtils;
import com.example.team3_kakaotalk._core.utils.Define;
import com.example.team3_kakaotalk.user.User;
import com.example.team3_kakaotalk.user.UserRequest;
import com.example.team3_kakaotalk.user.UserResponse;
import com.example.team3_kakaotalk.user.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    //    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginDTO reqDTO, Errors errors) {
//        UserResponse.loginDTO responseDTO = userService.login(reqDTO);
//        return ResponseEntity.ok(ApiUtils.success(responseDTO));
//    }
//
    //회원가입
    @PostMapping("/sign-up")
    public ResponseEntity<?> join(@Valid UserRequest.JoinDTO joinDTO) {

        userService.join(joinDTO);
        return ResponseEntity.ok().body(ApiUtils.success("회원가입 완료"));
    }

    //로그인
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginDTO loginDTO) {
        UserResponse.loginDTO responseDTO = userService.login(loginDTO);
        System.out.println();

        return ResponseEntity.ok().header("Authorization", "Bearer " + responseDTO.getJwt()).body(ApiUtils.success(responseDTO));
    }

    @GetMapping("/user/jwtTest")
    public ResponseEntity<?> jwtTest(@RequestBody UserRequest.LoginDTO reqDTO, Errors errors) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        return ResponseEntity.ok().body(ApiUtils.success(sessionUser));
    }


    //업데이트
    @PostMapping("/user/update")
    public ResponseEntity<?> update(@RequestBody @Valid UserRequest.UpdateDTO requestDTO, Errors errors) {
        User sessionUser = (User) session.getAttribute("sessionUser");

        UserResponse.UpdateResponseDTO responseDTO = userService.update(requestDTO, sessionUser);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
        @PostMapping("/autologin")
        public ResponseEntity<?> autologin () {
            User sessionUser = (User) session.getAttribute(Define.PRINCIPAL);

            UserResponse.loginDTO dto = userService.autoLogin(sessionUser);
            return ResponseEntity.ok().header("Authorization", "Bearer " + dto.getJwt()).body(ApiUtils.success(dto));
        }
    }


