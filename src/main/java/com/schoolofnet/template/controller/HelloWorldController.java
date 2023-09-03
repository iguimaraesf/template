package com.schoolofnet.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/hello");

        mv.addObject("name", "Leonan");

        return mv;
    }

    @GetMapping("/new")
    public String newPath(Model model) {
        List<String> list = new ArrayList<>();

        list.add("Leonan");
        list.add("Wesley");
        list.add("Victor");
        list.add("Luiz");
        list.add("Erik");

        model.addAttribute("name", "Leonan");
        model.addAttribute("list", list);

        return "new";
    }
}
