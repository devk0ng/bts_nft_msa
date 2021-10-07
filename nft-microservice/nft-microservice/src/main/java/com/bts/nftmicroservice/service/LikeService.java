package com.bts.nftmicroservice.service;

import com.bts.nftmicroservice.dto.LikeDto;
import com.bts.nftmicroservice.entity.Like;

import java.util.HashMap;
import java.util.List;

public interface LikeService {
    //기존 : likenft
    void saveLike(LikeDto likeDto);

    //기존 : likelist
    List<Like> retrieveLikes (String user);

    //기존 : deletelikenft
    void deleteLike(LikeDto likeDto);

    //기존 : countlike
    HashMap<String,Integer> countLikes(String nftId);
}
