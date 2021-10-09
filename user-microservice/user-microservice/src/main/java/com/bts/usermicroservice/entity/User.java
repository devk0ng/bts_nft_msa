package com.bts.usermicroservice.entity;

import com.bts.usermicroservice.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String social;
    private String name;

    @Column(unique = true)
    private String email;

    private String picture;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String coinWallet;

    public void updateWallet(String coinWallet){
        this.coinWallet = coinWallet;
    }
}
