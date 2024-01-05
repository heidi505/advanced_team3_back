package com.example.team3_kakaotalk.friend;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "friend_tb")
@ToString
@NoArgsConstructor
public class Friend{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer user_id1;
    private Integer user_id2;
    private boolean is_blocked;

    @Builder
    public Friend(Integer id, Integer user_id1, Integer user_id2, boolean is_blocked) {
        this.id = id;
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
        this.is_blocked = is_blocked;
    }
}
