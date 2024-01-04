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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginDTO reqDTO, Errors errors){
        UserResponse.loginDTO responseDTO = userService.login(reqDTO);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody @Valid UserRequest.JoinDTO reqDTO, Errors errors){
        userService.join(reqDTO);
        return ResponseEntity.ok().body(ApiUtils.success("로그인 성공"));
    }

    @GetMapping("/user/jwtTest")
    public ResponseEntity<?> jwtTest(@RequestBody UserRequest.LoginDTO reqDTO, Errors errors){
        User sessionUser = (User) session.getAttribute("sessionUser");
        return ResponseEntity.ok().body(ApiUtils.success(sessionUser));
    }
}
