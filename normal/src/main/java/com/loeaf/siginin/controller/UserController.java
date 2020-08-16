package com.loeaf.siginin.controller;

import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.model.UserForm;
import com.loeaf.siginin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getSignUpForm() {
        return "signUp";
    }

    @PostMapping
    public String signUp(@Valid @ModelAttribute UserForm userForm) {
        userService.save(convertFormToUser(userForm));
        return "redirect:/login";
    }

    private User convertFormToUser(UserForm userForm) {
        return User.builder()
                .email(userForm.getEmail())
                .nickName(userForm.getNickName())
                .password(userForm.getPassword())
                .build();
    }
}
