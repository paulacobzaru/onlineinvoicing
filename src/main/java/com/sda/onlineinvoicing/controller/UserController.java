package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Authority;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    UserService userService;

    @Autowired
    AuthoritiesService authoritiesService;

    @Autowired
    VatRateService vatRateService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/app/users")
    public String users(Model model) {
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("authorities", authoritiesService.getAll());
        return "/app/users";
    }

    @PostMapping("/app/saveUser")
    public String saveUser(Model model, User user) {
        //NOTE a default random password can be generated here
        if(user.getUserId()==0) {
            user.setPassword(passwordEncoder.encode("123456"));
        }else{
            user.setPassword(userService.getUserById(user.getUserId()).getPassword());
        }
//        Set<Authority> authorities = new HashSet<>();
//        authorities.add(authoritiesService.getAuthorities("USER"));
//        user.setAuthority(authoritiesService.getAuthorities("USER"));
        userService.saveUser(user);
        model.addAttribute("user", new User());
        model.addAttribute("message", "The user is created!");
        //NOTE we should redirect to users page instead of return it
        return "redirect:/app/users";
    }

    @GetMapping("/app/users/edit/{userId}")
    public String editUser(@PathVariable("userId") int userId, Model model) {
        //NOTE method name should be selected correctly and unique
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("cityList", cityService.getAllCities());
        //NOTE country list should be added
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("authorities", authoritiesService.getAll());
        return "/app/users";
    }

    @GetMapping("/app/users/delete/{userId}")
    public String deleteUser(@PathVariable("userId") int userId, Model model) {
        userService.deleteUser(userId);
        model.addAttribute("message", "Your user is deleted!");
        //NOTE redirect to error page after delete user, why?
        return "redirect:/app/users";
    }

    @PostMapping("/freetrial/saveUser")
    public String saveFreeTrialUser(Model model, User user) {
        //NOTE method name should be selected correctly and unique
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //we encode user password
        user.setAuthority(authoritiesService.getAuthorities("FREETRIAL"));
        userService.saveUser(user);
        model.addAttribute("user", new User());
        model.addAttribute("message", "The free trial user is created!");
        return "/pages/freetrial";
    }

    @GetMapping("/freetrial")
    public String freeTrial(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        return "/pages/freetrial";
    }
}
