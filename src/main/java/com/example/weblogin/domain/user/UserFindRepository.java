package com.example.weblogin.domain.user;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFindRepository {

    Optional<User> findId(String name, String email);

    // 회원이 비밀번호 찾기
    Optional<User> findPw(String id, String name, String email);
}
