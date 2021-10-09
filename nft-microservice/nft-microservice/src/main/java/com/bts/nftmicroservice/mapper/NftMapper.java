package com.bts.nftmicroservice.mapper;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.entity.NFT;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


public interface NftMapper {
    NftMapper INSTANCE = Mappers.getMapper(NftMapper.class);

    NftDto toNftDto(NFT nft);
}
