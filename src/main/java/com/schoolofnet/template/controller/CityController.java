package com.schoolofnet.template.controller;

import com.schoolofnet.template.model.City;
import com.schoolofnet.template.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    // TODO Sei que o correto é usar Service e dentro do Service o Repository.
    // TODO ...mas esta etapa está focada no spring web.
    private final CityRepository cityRepository;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        return "cities/index";
    }

    @PostMapping
    public String create(@ModelAttribute("city") City city, Model model) {
        cityRepository.save(city);
        return "redirect:/cities";
    }

    @GetMapping("/new")
    public String newCity(Model model) {
        model.addAttribute("city", new City());
        return "cities/new";
    }

    @GetMapping("/{id}")
    public String editCity(@PathVariable("id") Long id, Model model) {
        model.addAttribute("city", cityRepository.findById(id).orElseThrow());
        return "cities/edit";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("city") City city, Model model) {
        final City bd = cityRepository.findById(id).orElseThrow();
        bd.setName(city.getName());
        cityRepository.save(bd);
        return "redirect:/cities";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        cityRepository.deleteById(id);
        return "redirect:/cities";
    }
}
