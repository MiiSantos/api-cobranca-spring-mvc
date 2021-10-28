package com.algaworks.crudcobranca.controller;

import com.algaworks.crudcobranca.model.StatusTitle;
import com.algaworks.crudcobranca.model.Title;
import com.algaworks.crudcobranca.repository.Titles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titles")
public class TitleController {

    private static final String NEW_TITLE = "TitleRegistration";
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

        ModelAndView mv = new ModelAndView(NEW_TITLE);
        mv.addObject(new Title());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Validated Title title, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors())
            return NEW_TITLE;
        titles.save(title);
        attributes.addFlashAttribute("message", "Título salvo com sucesso!");
        return "redirect:/titles/new";
    }

    @RequestMapping("{code}")
    public ModelAndView edit(@PathVariable("code") Title title) {
        ModelAndView mv = new ModelAndView(NEW_TITLE);
        mv.addObject(title);

        return mv;
    }

    @ModelAttribute("allStatus")
    public List<StatusTitle> allStatus() {
        return Arrays.asList(StatusTitle.values());
    }
}
