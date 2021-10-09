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

    @Test
    void likeTest() {
        NftDto nftDto = new NftDto();

        nftDto.setKlayId("12");
        nftDto.setImage("image1");
        nftDto.setDescription("des1");
        nftDto.setImagePath("path1");
        nftDto.setName("name1");
        nftDto.setOwner(1L);

        nftService.saveNft(nftDto);

        nftDto = new NftDto();

        nftDto.setKlayId("1234");
        nftDto.setImage("image2");
        nftDto.setDescription("des2");
        nftDto.setImagePath("path2");
        nftDto.setName("name2");
        nftDto.setOwner(2L);

        nftService.saveNft(nftDto);
    }
}
