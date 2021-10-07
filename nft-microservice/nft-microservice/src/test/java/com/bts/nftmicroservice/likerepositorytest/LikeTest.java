package com.bts.nftmicroservice.likerepositorytest;

import com.bts.nftmicroservice.repository.LikeRepository;
import com.bts.nftmicroservice.service.LikeService;
import com.bts.nftmicroservice.service.NftService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LikeTest {
    @Autowired
    LikeRepository likeRepository;
    @Autowired
    LikeService likeService;
    @Autowired
    NftService nftService;

    @Test
    void likeTest() {

    }
}
