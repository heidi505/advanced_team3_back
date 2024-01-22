package com.example.team3_kakaotalk.friend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FriendJPARepository extends JpaRepository<Friend, Integer> {

    @Transactional
    @Modifying
    @Query("update Friend f SET f.isFavorite = :newStatus WHERE f.userId1 = :userId1 AND f.userId2 = :userId2")
    int updateByUserId(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2, @Param("newStatus") boolean newStatus);
}
