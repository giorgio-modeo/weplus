package com.prova.spring5.controllers;

import com.prova.spring5.Repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {
    public final AuthorRepository authorRepository;
    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("author")
    public String getBooks(Model model){
        model.addAttribute("author", authorRepository.findAll());

        return "author/list";
    }
}
