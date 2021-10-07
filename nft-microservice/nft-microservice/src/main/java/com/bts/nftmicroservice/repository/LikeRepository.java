package com.bts.nftmicroservice.repository;

import com.bts.nftmicroservice.entity.Like;
import com.bts.nftmicroservice.entity.NFT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByuserId(String userId);

    @Query("select l.nft from Like l join fetch l.nft where l.userId= :userId")
    List<NFT> findNftByuserId(@Param("userId") String userId);
}
