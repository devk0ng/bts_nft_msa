package com.bts.nftmicroservice.repository;

import com.bts.nftmicroservice.entity.NFT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NftRepository extends JpaRepository<NFT, Long> {
    List<NFT> findByuserId(Long userId);

    @Query("select n from NFT n join fetch n.likes where n.id= :nftId")
    NFT findByNftId(@Param("nftId") Long nftId);
}
