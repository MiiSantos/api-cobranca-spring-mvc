package com.algaworks.crudcobranca.controller;

import com.algaworks.crudcobranca.model.Title;
import com.algaworks.crudcobranca.repository.Titles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/titles")
public class TitleController {

    @Autowired
    private Titles titles;

    @RequestMapping("/new")
    public String newTitle() {
        return "TitleRegistration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(Title title) {

        titles.save(title);
        return "TitleRegistration";
    }

}
