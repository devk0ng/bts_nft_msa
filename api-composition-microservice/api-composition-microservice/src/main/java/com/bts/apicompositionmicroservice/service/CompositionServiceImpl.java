package com.bts.apicompositionmicroservice.service;

import com.bts.apicompositionmicroservice.dto.NftDto;
import com.bts.apicompositionmicroservice.rest.nft.NftFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompositionServiceImpl implements CompositionService{
    private final NftFeignClient nftFeignClient;
    @Override
    public NftDto findNftByNftId(String nftId) {

        return nftFeignClient.findNft(nftId);
    }
}
