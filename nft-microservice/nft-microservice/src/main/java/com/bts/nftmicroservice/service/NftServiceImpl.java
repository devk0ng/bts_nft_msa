package com.bts.nftmicroservice.service;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.dto.SendDto;
import com.bts.nftmicroservice.entity.NFT;
import com.bts.nftmicroservice.mapper.NftMapper;
import com.bts.nftmicroservice.repository.NftRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class NftServiceImpl implements NftService{
    private final NftRepository nftRepository;

    @Override
    public void saveNft(NftDto nftDto) {

        NFT nft = NFT.builder().klayId(nftDto.getKlayId())
                .name(nftDto.getName())
                .date(LocalDateTime.now())
                .description(nftDto.getDescription())
                .image(nftDto.getImage())
                .userId(nftDto.getUserId())
                .imagePath(nftDto.getImagePath())
                .build();

        nftRepository.save(nft);
    }

    @Override
    public List<NFT> findNftByUserId(Long userId) {
        return nftRepository.findByuserId(userId);
    }

    @Override
    public NftDto findNftByNftId(String nftId) {
        NFT nft = nftRepository.findById(Long.parseLong(nftId)).get();
        NftDto nftDto = NftMapper.INSTANCE.toNftDto(nft);

        return nftDto;
    }

    @Override
    public List<NFT> findNftAll() {
        return nftRepository.findAll();
    }

    @Override
    public void moveNft(SendDto sendDto) {
        NFT nft = nftRepository.findById(Long.parseLong(sendDto.getId())).get();
        nft.changeOwner(Long.parseLong(sendDto.getTo()));
        nft.updateDate();
    }

    @Override
    public void deleteNft(Long nftId) {
        NFT nft = nftRepository.findById(nftId).get();
        nftRepository.delete(nft);
    }
}
