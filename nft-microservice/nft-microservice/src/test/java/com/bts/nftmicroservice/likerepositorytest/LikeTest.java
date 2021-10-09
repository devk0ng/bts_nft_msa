package com.bts.nftmicroservice.likerepositorytest;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.repository.LikeRepository;
import com.bts.nftmicroservice.service.LikeService;
import com.bts.nftmicroservice.service.NftService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public class LikeTest {
   // @Autowired
   // LikeRepository likeRepository;
    @Autowired
    LikeService likeService;
    @Autowired
    NftService nftService;

}
