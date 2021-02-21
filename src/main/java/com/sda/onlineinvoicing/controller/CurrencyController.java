package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Currency;
import com.sda.onlineinvoicing.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/app/currencies")
    public String currency(Model model){
        model.addAttribute("currency", new Currency());
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        return "/app/currencies";
    }

    @PostMapping("/app/currencies/saveCurrency")
    public String saveCurrency(Model model, Currency currency){
        currencyService.saveCurrency(currency);
        model.addAttribute("currency", new Currency());
        model.addAttribute("message", "Your currency is saved!");
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        return "/app/currencies";
    }

    @GetMapping("/app/currencies/edit/{currencyId}")
    public String editCurrency(@PathVariable("currencyId") int currencyId, Model model){
        model.addAttribute("currency", currencyService.getCurrencyById(currencyId));
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        return "/app/currencies";
    }

    @GetMapping("/app/currencies/delete/{currencyId}")
    public String deleteCurrency(@PathVariable("currencyId") int currencyId, Model model){
        currencyService.deleteCurrency(currencyId);
        model.addAttribute("message", "Your currency is deleted!");
        return "redirect:/app/currencies";
    }
}
