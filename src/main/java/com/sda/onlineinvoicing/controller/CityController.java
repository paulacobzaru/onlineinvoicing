package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.City;
import com.sda.onlineinvoicing.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/app/cities")
    public String city(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("cityList", cityService.getAllCities());
        return "/app/cities";
    }

    @PostMapping("/app/cities/saveCity")
    public String saveCity(Model model, City city) {
        cityService.saveCity(city);
        model.addAttribute("city", new City());
        model.addAttribute("message", "Your city is saved!");
        model.addAttribute("cityList", cityService.getAllCities());
        return "/app/cities";
    }

    @GetMapping("/app/cities/edit/{cityId}")
    public String editCity(@PathVariable("cityId") int cityId, Model model) {
        model.addAttribute("city", cityService.getCityById(cityId));
        model.addAttribute("cityList", cityService.getAllCities());
        return "/app/citie";
    }

    @GetMapping("/app/cities/delete/{cityId}")
    public String deleteCity(@PathVariable("cityId") int cityId, Model model) {
        cityService.getCityById(cityId);
        model.addAttribute("message", "Your city is saved!");
        return "redirect:/app/cities";
    }
}

