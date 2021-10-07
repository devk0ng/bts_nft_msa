package com.bts.nftmicroservice.service;

import com.bts.nftmicroservice.dto.LikeDto;
import com.bts.nftmicroservice.entity.Like;
import com.bts.nftmicroservice.entity.NFT;
import com.bts.nftmicroservice.repository.LikeRepository;
import com.bts.nftmicroservice.repository.NftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeServiceImpl implements LikeService{
    private final LikeRepository likeRepository;
    private final NftRepository nftRepository;

    @Override
    public void saveLike(LikeDto likeDto) {
        NFT nft = nftRepository.findById(Long.parseLong(likeDto.getNftId())).get();

        Like like = Like.builder()
                .nft(nft)
                .userId(Long.parseLong(likeDto.getUserId()))
                .build();

        nft.getLikes().add(like);

        likeRepository.save(like);
    }

    @Override
    public List<Like> retrieveLikes(String userId) {
        return likeRepository.findByuserId(userId);
    }

    @Override
    public void deleteLike(LikeDto likeDto) {
        NFT nft = nftRepository.findByNftId(Long.parseLong(likeDto.getNftId()));
        List<Like> likes = nft.getLikes();

        for(Like like : likes) {
            if(like.getUserId() == Long.parseLong(likeDto.getUserId())) {
                likes.remove(like);
                break;
            }
        }
    }

    @Override
    public HashMap<String, Integer> countLikes(String nftId) {
        NFT nft = nftRepository.findByNftId(Long.parseLong(nftId));

        HashMap<String, Integer> result = new HashMap<>();
        result.put("count", nft.getLikes().size());

        return result;
    }
}
