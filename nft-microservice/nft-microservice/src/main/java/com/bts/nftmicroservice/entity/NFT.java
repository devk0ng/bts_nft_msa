package com.bts.nftmicroservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NFT {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nft_id")
    private Long id;
    private String klayId;
    private String name;
    private String description;
    private String image;
    private LocalDateTime date;
    private String imagePath;
    private Long userId;

    @OneToMany(mappedBy = "nft", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Like> likes = new ArrayList<>();

    public void changeOwner(Long newUserId) {
        this.userId = newUserId;
    }

    public void updateDate() {
        date = LocalDateTime.now();
    }

}
