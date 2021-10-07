package com.bts.nftmicroservice.dto;

import lombok.Data;

@Data
public class NftDto {
    private String klayId;
    private String name;
    private String description;
    private String image;
    private Long owner;
    private String date;
    private String imagePath;
}
