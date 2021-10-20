package com.algaworks.crudcobranca.controller;

import com.algaworks.crudcobranca.model.StatusTitle;
import com.algaworks.crudcobranca.model.Title;
import com.algaworks.crudcobranca.repository.Titles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private Titles titles;

    @RequestMapping
    public ModelAndView findTitles() {

        List<Title> allTitles = titles.findAll();
        ModelAndView mv = new ModelAndView("Titles");
        mv.addObject("titles", allTitles);
        return mv;
    }

    @RequestMapping("/new")
    public ModelAndView newTitle() {

        ModelAndView mv = new ModelAndView("TitleRegistration");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Title title) {

        titles.save(title);
        ModelAndView mv = new ModelAndView("TitleRegistration");
        mv.addObject("message", "Título salvo com sucesso!");
        return mv;
    }

    @ModelAttribute("allStatus")
    public List<StatusTitle> allStatus() {
        return Arrays.asList(StatusTitle.values());
    }
}
