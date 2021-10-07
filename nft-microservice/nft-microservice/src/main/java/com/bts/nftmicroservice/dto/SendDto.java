package com.bts.nftmicroservice.dto;

import lombok.Data;

@Data
public class SendDto {
    private String id;
    private String to;
    private String from;
}
