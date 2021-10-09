package com.bts.apicompositionmicroservice.service;

import com.bts.apicompositionmicroservice.dto.NftDto;

public interface CompositionService {
    NftDto findNftByNftId(String nftId);
}
