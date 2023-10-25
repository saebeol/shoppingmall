package com.example.weblogin.service;

import com.example.weblogin.domain.user.User;

import java.util.Optional;

public interface UserService {

    User userFindId(String name,String email);

    User userFindPw(String id, String name, String email);

}
