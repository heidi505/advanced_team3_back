package com.example.team3_kakaotalk.friend;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.example.team3_kakaotalk.user.User;

@Data
@Entity
@Table(name = "friend_tb", uniqueConstraints = {
        @UniqueConstraint(
                name = "user1_user2_unique",
                columnNames = {"user_id1","user_id2"}
        )
})
@ToString
@NoArgsConstructor
public class Friend{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id1;
    private Integer user_id2;
    private Boolean is_blocked;

    @Builder
    public Friend(Integer id, Integer user_id1, Integer user_id2, boolean is_blocked) {
        this.id = id;
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
        this.is_blocked = is_blocked;
    }
}
