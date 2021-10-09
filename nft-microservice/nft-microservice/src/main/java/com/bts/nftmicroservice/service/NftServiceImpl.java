package com.bts.nftmicroservice.service;

import com.bts.nftmicroservice.dto.NftDto;
import com.bts.nftmicroservice.dto.SendDto;
import com.bts.nftmicroservice.entity.NFT;
import com.bts.nftmicroservice.repository.NftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NftServiceImpl implements NftService{
    private final NftRepository nftRepository;

    @Override
    public void saveNft(NftDto nfTDto) {
        NFT nft = NFT.builder().klayId(nfTDto.getKlayId())
                .name(nfTDto.getName())
                .date(LocalDateTime.now())
                .description(nfTDto.getDescription())
                .image(nfTDto.getImage())
                .userId(nfTDto.getOwner())
                .imagePath(nfTDto.getImagePath())
                .build();

        nftRepository.save(nft);
    }

    @Override
    public List<NFT> findNftByUserId(Long userId) {
        return nftRepository.findByuserId(userId);
    }

    @Override
    public NFT findNftByNftId(String nftId) {
        return nftRepository.findById(Long.parseLong(nftId)).get();
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
