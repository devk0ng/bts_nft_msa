package com.bts.nftmicroservice.controller;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.service.LikeService;
import com.bts.nftmicroservice.service.NftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NftController {
    private final NftService nftService;
    private final LikeService likeService;

    @PostMapping("/api/savenft")
    public void saveNft(@RequestBody NftDto nftDto) {
        nftService.saveNft(nftDto);
    }

    @GetMapping("/api/findnft/{nftId}")
    public NftDto findNft(@PathVariable String nftId) {
        return nftService.findNftByNftId(nftId);
    }
}
