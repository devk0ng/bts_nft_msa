package com.bts.usermicroservice.service;

import com.bts.usermicroservice.dto.Oauth2AttributeDto;
import com.bts.usermicroservice.entity.User;

import java.util.HashMap;
import java.util.Optional;

public interface UserService {
    User userSaveOrUpdate(Oauth2AttributeDto oauth2AttributeDto);
    User findByEmailAndSocial(String email, String social);
    //기존 : findById
    String findAddressById(Long id);
    //기존 : insertwallet
    void saveWallet(HashMap<String,String> wallet);
}
