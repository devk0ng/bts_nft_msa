package com.bts.usermicroservice.service;

import com.bts.usermicroservice.entity.User;
import com.bts.usermicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public User findByEmailAndSocial(String email, String social) {
        List<User> user = userRepository.findByEmailAndSocial(email, social);

        if(user.size() == 0)
            return null;
        else
            return user.get(0);
    }

    public void saveWallet(HashMap<String, String> wallet) {
        Long id = Long.parseLong(wallet.get("id"));
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(selectUser -> {
            selectUser.updateWallet(wallet.get("address"));
        });
    }

    public String findAddressById(Long id) {
        return userRepository.findWalletAddressById(id);
    }
}
