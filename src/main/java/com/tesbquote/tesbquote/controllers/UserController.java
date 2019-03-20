package com.tesbquote.tesbquote.controllers;

import com.tesbquote.tesbquote.models.User;
import com.tesbquote.tesbquote.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
//@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "login-register", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("title", "Miami Tile Installers");

        return "user/login-register";

    }

    @RequestMapping(value = "login-register", method = RequestMethod.POST)
    public String adduser(Model model, @ModelAttribute @Valid User newUser, Errors errors) {

        model.addAttribute("title", "Miami Tile Installers");
        userDao.save(newUser);
        model.addAttribute("id",newUser.getId());
        model.addAttribute("email",newUser.getEmail());

        return "user/profile-update";
    }


    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model, @RequestParam int id){
//        model.addAttribute("id",id);
        model.addAttribute("title", "Miami Tile Installers");
        model.addAttribute("profile", userDao.findById(id));
        return "user/profile";
    }

    @PostMapping("/my-profile")
    public String updateprofile(Model model, @ModelAttribute @Valid User newUser, Errors errors) {
//        User userUpdate = userDao.findById(newUser.getId()).orElse(null);
        User userUpdate = userDao.findByEmail(newUser.getEmail());
//        newUser = user.get();
//        userUpdate.setEmail(newUser.getEmail());
//        userUpdate.setUsername(newUser.getUsername());
//        userUpdate.setUsername(newUser.getPassword());
        userUpdate.setName(newUser.getName());
        userUpdate.setLastName(newUser.getLastName());
        userUpdate.setRate(newUser.getRate());
        userUpdate.setPhone(newUser.getPhone());
        userDao.save(userUpdate);



        model.addAttribute("title", "Miami Tile Installers");
        model.addAttribute("id",userUpdate.getId());
//        model.addAttribute("email",userUpdate.getEmail());
        model.addAttribute("name",userUpdate.getName());
        model.addAttribute("lastName",userUpdate.getLastName());
        model.addAttribute("phone",userUpdate.getPhone());
        model.addAttribute("email",userUpdate.getEmail());
//        model.addAttribute("rate", .getRate());
//        model.addAttribute("rates",rateDao.findAll());
//        model.addAttribute("rateFactors",rateFactorDao.findAll());
        return "user/profile";
    }

}
