package com.bts.usermicroservice.dto;

import lombok.Data;

@Data
public class Oauth2AttributeDto {
    private String attributeKey;
    private String email;
    private String name;
    private String picture;
}
