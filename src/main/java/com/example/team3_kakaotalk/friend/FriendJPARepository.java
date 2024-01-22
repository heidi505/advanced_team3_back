package com.example.team3_kakaotalk.friend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FriendJPARepository extends JpaRepository<Friend, Integer> {

//<<<<<<< HEAD
//    @Transactional
//    @Modifying
//    @Query("update Friend f SET f.isFavorite = :newStatus WHERE f.userId1 = :userId1 AND f.userId2 = :userId2")
//    int updateByUserId(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2, @Param("newStatus") boolean newStatus);
//=======

//    @Modifying
//    @Query("update Friend f set f.isFavorite = :newStatus where f.id = :id")
//    int updateFavorite(@Param("id") Integer id, @Param("newStatus") boolean newStatus);

    //    @Query("select ft from Friend ft where ft.userId1=:userId1 and ft.userId2=:userId2")
//    @Query("update Friend ft set ft.isFavorite = :newStatus where ft.userId1 = :userId1 and ft.userId2 = :userId2")
//    int updateByUserId(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2, @Param("newStatus") boolean newStatus);
//    @Transactional
//    @Modifying
//    @Query("update Friend f SET f.isFavorite = :newStatus WHERE f.userId1 = :userId1 AND f.userId2 = :userId2")
//    int updateByUserId(@Param("userId1") Integer userId1, @Param("userId2") Integer userId2, @Param("newStatus") boolean newStatus);
//>>>>>>> bb2b3310708bc738194c39b291b3e6b3d70d1c7c
}
