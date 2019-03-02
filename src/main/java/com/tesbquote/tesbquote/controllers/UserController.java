package com.tesbquote.tesbquote.controllers;

import com.tesbquote.tesbquote.models.User;
import com.tesbquote.tesbquote.models.data.RateDao;
import com.tesbquote.tesbquote.models.data.RateFactorDao;
import com.tesbquote.tesbquote.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
//@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RateDao rateDao;

    @Autowired
    private RateFactorDao rateFactorDao;

    @RequestMapping(value = "login-register", method = RequestMethod.GET)
    public String login(Model model) {


        return "user/login-register";
    }

    @RequestMapping(value = "login-register", method = RequestMethod.POST)
    public String adduser(Model model, @ModelAttribute @Valid User newUser, Errors errors) {
        userDao.save(newUser);
        model.addAttribute("id",newUser.getId());
        model.addAttribute("username",newUser.getUsername());
        model.addAttribute("email",newUser.getEmail());
        model.addAttribute("rates",rateDao.findAll());
        model.addAttribute("rateFactors",rateFactorDao.findAll());
        return "user/profile-update";
    }


    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model, @RequestParam int id){
//        model.addAttribute("id",id);
        model.addAttribute("profile", userDao.findById(id));
        return "user/profile";
    }

    @PostMapping("/updateprofile")
    public String updateprofile(Model model, @ModelAttribute @Valid User newUser, Errors errors) {
        User userUpdate = userDao.findById(newUser.getId()).orElse(null);
//        newUser = user.get();
//        userUpdate.setEmail(newUser.getEmail());
//        userUpdate.setUsername(newUser.getUsername());
//        userUpdate.setUsername(newUser.getPassword());
//        userUpdate.setName(newUser.getName());
//        userUpdate.setLastName(newUser.getLastName());
//        userDao.save(userUpdate);




        model.addAttribute("id",newUser.getId());
//        model.addAttribute("email",userUpdate.getEmail());
        model.addAttribute("name",newUser.getName());
        model.addAttribute("lastName",newUser.getLastName());
//        model.addAttribute("rates",rateDao.findAll());
//        model.addAttribute("rateFactors",rateFactorDao.findAll());
        return "user/hello1";
    }

}
