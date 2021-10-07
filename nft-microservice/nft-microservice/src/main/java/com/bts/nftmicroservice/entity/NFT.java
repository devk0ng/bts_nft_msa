package com.bts.nftmicroservice.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
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

    @OneToMany(mappedBy = "nft", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Like> likes;

}
