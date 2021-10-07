package com.bts.nftmicroservice.dto;

import com.bts.nftmicroservice.entity.NFT;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class LikeDto {
    private String nftId;
    private String userId;
}
