package com.example.weblogin.domain.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.sql.DataSource;
import java.util.*;

@Slf4j
@Repository
public class UserRepositoryV1 implements UserFindRepository{

    private final NamedParameterJdbcTemplate template;

    public UserRepositoryV1(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    // 유저 아이디 찾기
    @Override
    public Optional<User> findId(String name, String email) {
        String sql = "select * from user where name=:name and email=:email";
        try {
            Map<String,Object> param = Map.of("name",name,"email",email);
            User user = template.queryForObject(sql, param, UserRowMapper());
//            log.info(String.valueOf(user.getId()));
            return Optional.of(user);
        }catch(EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    private RowMapper<User> UserRowMapper() {
        return BeanPropertyRowMapper.newInstance(User.class);
    }

    // 유저 비밀번호 찾기
    @Override
    public Optional<User> findPw(String username, String name, String email) {
        String sql = "select * from user where username=:username and name=:name and email=:email";
        try{
            Map<String,Object> param = Map.of("username",username,"name",name,"email",email);
            User user = template.queryForObject(sql,param,UserRowMapper());
            return Optional.of(user);
        }catch(EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
}
