package com.bts.usermicroservice.repository;

import com.bts.usermicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAndSocial(String email, String social);

    @Query("select u.coinWallet from User u where u.id= :id")
    String findWalletAddressById(@Param("id") Long id);
}
