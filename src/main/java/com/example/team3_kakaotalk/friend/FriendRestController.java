package com.example.team3_kakaotalk.friend;

import com.example.team3_kakaotalk._core.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendRestController {

    @Autowired
    private FriendService friendService;

    // 친구 즐겨찾기 추가, 해제
    @PutMapping("/favorite/{id}")
    public ResponseEntity<?> favoriteFriend(@PathVariable Integer id, @RequestBody Map<String, Boolean> requestBody) {
        boolean newStatus = requestBody.get("newStatus");
        String response = friendService.favoriteFriend(id, newStatus);
        return ResponseEntity.ok().body(ApiUtils.success(response));
    }


}
