package com.example.weblogin.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class FindPwForm {
    @NotBlank(message = "찾을 비밀번호의 아이디를 입력해주세요.")
    private String id;
    @NotBlank(message = "찾을 비밀번호의 이름을 입력해주세요.")
    private String name;
    @NotBlank(message = "찾을 비밀번호의 이메일을 입력해주세요.")
    @Email
    private String email;
}
