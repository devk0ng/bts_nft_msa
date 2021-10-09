package com.bts.nftmicroservice.service;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.dto.SendDto;
import com.bts.nftmicroservice.entity.NFT;

import java.util.HashMap;
import java.util.List;

public interface NftService {
    void saveNft(NftDto nftDto);
    List<NFT> findNftByUserId(Long userId);
    NftDto findNftByNftId(String nftId);
    List<NFT> findNftAll();
    void moveNft(SendDto sendDto);
    void deleteNft(Long nftId);
}
