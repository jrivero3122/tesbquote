package com.tesbquote.tesbquote.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Float.valueOf;

@Controller
public class IndexController {

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("title", "Tesbquote");

        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index(HttpServletRequest request, Model model){

        Float tileSizeLenght = valueOf(request.getParameter("tileSizeLenght"));
        Float tileSizeWidth = valueOf(request.getParameter("tileSizeWidth"));
        Float surface = valueOf(request.getParameter("surface"));
        String typeOfTile = request.getParameter("typeOfTile");

        Float sqftile = (tileSizeLenght * tileSizeWidth)/144;
        Float qtyOfTile = surface / sqftile;

        model.addAttribute("tileSizeLenght",tileSizeLenght);
        model.addAttribute("tileSizeWidth",tileSizeWidth);
        model.addAttribute("surface",surface);
        model.addAttribute("qtyOfTile", (int)Math.ceil(qtyOfTile));
        model.addAttribute("typeOfTile",typeOfTile);

        return "searchquote";
    }



}
