package com.example.weblogin.controller;

import com.example.weblogin.domain.FindIdForm;
import com.example.weblogin.domain.FindPwForm;
import com.example.weblogin.domain.user.User;
import com.example.weblogin.service.AuthService;
import com.example.weblogin.service.UserServiceV1;
import com.example.weblogin.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final UserServiceV1 userService;
    private final AuthService authService;

    @GetMapping("/signin")
    public String SigninForm() {
        return "signin";
    }

    @GetMapping("/signup")
    public String SignupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(SignupDto signupDto) {
        // User에 signupDto 넣음
        User user = signupDto.toEntity();

        User userEntity = authService.signup(user);
        System.out.println(userEntity);

        return "signin";
    }

    @GetMapping("/findId")
    public String findIdForm(@ModelAttribute("findIdForm") FindIdForm form) {
        return "/findIdForm";
    }

    @PostMapping("/findId")
    public String findId(@Valid @ModelAttribute("findIdForm") FindIdForm form, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "/findIdForm";
        }

        User findIdUser = userService.userFindId(form.getName(),form.getEmail());
        model.addAttribute("findIdUser",findIdUser);

        if(findIdUser == null) {
            result.reject("findIdFail", "일치하는 아이디가 없습니다.");

            return "/findIdForm";
        }

        return "/successFindId";
    }

    @GetMapping("/findPw")
    public String findPwForm(@ModelAttribute("findPwForm") FindPwForm form) {
        return "/findPwForm";
    }

    @PostMapping("/findPw")
    public String findPw(@Valid @ModelAttribute("findPwForm") FindPwForm form, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "/findPwForm";
        }

        User findPwUser = userService.userFindPw(form.getId(),form.getName(),form.getEmail());
        model.addAttribute("findPwUser",findPwUser);

        if(findPwUser == null) {
            result.reject("findPwFail","일치하는 회원이 없습니다.");

            return "/findPwForm";
        }

        return "/successFindPw";
    }
}
