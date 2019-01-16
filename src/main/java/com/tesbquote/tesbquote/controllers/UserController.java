package com.tesbquote.tesbquote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "user")
public class UserController {
    @RequestMapping(value = "login-register")
    public String login() {
        return "user/login-register";
    }
}
