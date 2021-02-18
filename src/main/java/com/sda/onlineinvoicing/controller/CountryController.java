package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Country;
import com.sda.onlineinvoicing.service.CityService;
import com.sda.onlineinvoicing.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @GetMapping("/app/countries")
    public String country(Model model) {
        model.addAttribute("country", new Country());
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        return "/app/countries";
    }

    @PostMapping("/app/saveCountry")
    public String saveCountry(Model model, Country country){
        countryService.saveCountry(country);
        model.addAttribute("country", new Country());
        model.addAttribute("message", "Your country is saved!");
        model.addAttribute("cityList",cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        return "/app/countries";
    }

    @GetMapping("/app/countries/delete/{deleteId}")
    public String deleteCountry(@PathVariable("countryId") int countryId, Model model) {
        countryService.deleteCountry(countryId);
        model.addAttribute("message", "Your country is deleted!");
        return "redirect:/app/countries";
    }

    @GetMapping("/app/countries/edit/{countryId}")
    public String getCountry(@PathVariable("countryId") int countryId, Model model){
        model.addAttribute("country", countryService.getCountryById(countryId));
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        return "/app/countries";
    }
}
