package com.example.team3_kakaotalk.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class FriendService {

    @Autowired
    FriendJPARepository friendJPARepository;

    // 친구 즐겨찾기 등록,해제
    @Transactional
    public String favoriteFriend(Integer id, boolean newStatus) {
        Friend friend = friendJPARepository.findById(id).orElseThrow(() -> new RuntimeException("친구아님!"));

        //friend.setFriend(newStatus);
        friendJPARepository.save(friend);

        if (newStatus) {
            return "등록되었습니다";
        } else {
            return "해제되었습니다.";
        }
    }
}
