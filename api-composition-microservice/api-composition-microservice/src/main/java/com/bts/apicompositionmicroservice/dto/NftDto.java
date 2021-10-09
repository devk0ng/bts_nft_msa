package com.bts.apicompositionmicroservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NftDto {
    private Long id;
    private String klayId;
    private String name;
    private String description;
    private String image;
    private LocalDateTime date;
    private String imagePath;
    private Long userId;
}

