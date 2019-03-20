package com.tesbquote.tesbquote.controllers;


//import com.tesbquote.tesbquote.models.Rate;
//import com.tesbquote.tesbquote.models.RateFactor;
//import com.tesbquote.tesbquote.models.data.RateDao;
//import com.tesbquote.tesbquote.models.data.RateFactorDao;
import com.tesbquote.tesbquote.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.valueOf;

@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private RateDao rateDao;

//    @Autowired
//    private RateFactorDao rateFactor;

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Miami Tile Installers");


//        model.addAttribute("ratesFactor",rateFactor.findAll());

        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(HttpServletRequest request, Model model){

//        List<Rate> finalRate =

//        Iterable<Rate> data = rateDao.findAll();

        model.addAttribute("title", "Miami Tile Installers");


        Float tileSizeLenght = valueOf(request.getParameter("tileSizeLenght"));
        Float tileSizeWidth = valueOf(request.getParameter("tileSizeWidth"));
        Float surface = valueOf(request.getParameter("surface"));
        String typeOfTile = request.getParameter("typeOfTile");

        Float sqftile = (tileSizeLenght * tileSizeWidth)/144;
        Float qtyOfTile = surface / sqftile;


//        String username = data.iterator().next().getUser().getName();
//        String email = data.iterator().next().getUser().getEmail();
//        Float finalRate = data.iterator().next().getRate().floatValue()*surface;

        model.addAttribute("tileSizeLenght",tileSizeLenght);
        model.addAttribute("tileSizeWidth",tileSizeWidth);
        model.addAttribute("surface",surface);
        model.addAttribute("qtyOfTile", (int)Math.ceil(qtyOfTile));
        model.addAttribute("typeOfTile",typeOfTile);
//        model.addAttribute("finalRate",finalRate);

        model.addAttribute("users",userDao.findAll());
//        model.addAttribute("rates",rateDao.findAll());
//        model.addAttribute("rates",data);


        return "index";
    }



}
