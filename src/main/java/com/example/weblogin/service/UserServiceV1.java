package com.example.weblogin.service;

import com.example.weblogin.domain.user.User;
import com.example.weblogin.domain.user.UserRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceV1 implements UserService{

    private final UserRepositoryV1 userRepository;

    @Override
    public User userFindId(String name,String email) {
        return userRepository.findId(name,email).filter(u -> u.getName().equals(name)).filter(u -> u.getEmail().equals(email)).orElse(null);
    }

    @Override
    public User userFindPw(String username, String name, String email) {
        return userRepository.findPw(username, name, email).filter(u -> u.getUsername().equals(username)).filter(u -> u.getName().equals(name)).filter(u -> u.getEmail().equals(email)).orElse(null);
    }
}
