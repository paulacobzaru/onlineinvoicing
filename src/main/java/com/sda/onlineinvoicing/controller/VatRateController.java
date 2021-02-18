package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.VatRate;
import com.sda.onlineinvoicing.service.VatRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VatRateController {

    @Autowired
    VatRateService vatRateService;

    @GetMapping("/app/vat_rate")
    public String vatRate(Model model) {
        model.addAttribute("vatRate", new VatRate());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/vat_rate";
    }

    @PostMapping("/app/saveVatRate")
    public String saveVatRate(Model model, VatRate vatRate) {
        vatRateService.saveVatRate(vatRate);
        model.addAttribute("vatRate", new VatRate());
        model.addAttribute("message", "Your Vat rate is created!");
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "redirect:/app/vat_rate";
    }

    @GetMapping("/app/vat_rate/delete/{vatRateId}")
    public String deleteVatRate(@PathVariable("vatRateId") int vatRateId, Model model) {
        vatRateService.deleteVatRate(vatRateId);
        model.addAttribute("message", "Your vat rate is deleted");
        return "redirect:/app/vat_rate";
    }

    @GetMapping("/app/vat_rate/edit/{vatRateId}")
    public String getVatRate(@PathVariable("vatRateId") int vatRateId, Model model) {
        model.addAttribute("vatRate", vatRateService.getVatRateById(vatRateId));
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/vat_rate";
    }

}



