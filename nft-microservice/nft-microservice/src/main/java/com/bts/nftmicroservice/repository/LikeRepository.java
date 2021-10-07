package com.bts.nftmicroservice.repository;

import com.bts.nftmicroservice.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByuserId(String userId);
}
