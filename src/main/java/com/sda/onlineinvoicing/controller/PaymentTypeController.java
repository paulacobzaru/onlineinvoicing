package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.PaymentType;
import com.sda.onlineinvoicing.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping("/app/payment_type")
    public String paymentTypes(Model model) {
        model.addAttribute("paymentType", new PaymentType());
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        return "/app/payment_type";
    }

    @PostMapping("/app/savePaymentType")
    public String savePaymentType(Model model, PaymentType paymentType) {
        paymentTypeService.savePaymentType(paymentType);
        model.addAttribute("paymentType", new PaymentType());
        model.addAttribute("message", "Your payment type is created!");
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        return "/app/payment_type";
    }

    @GetMapping("/app/payment_type/edit/{paymentTypeId}")
    public String editPaymentType(@PathVariable("paymentTypeId") int paymentTypeId, Model model) {
        model.addAttribute("paymentType", paymentTypeService.getPaymentTypeById(paymentTypeId));
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        return "/app/payment_type";
    }

    @GetMapping("/app/payment_type/delete/{paymentTypeId}")
    public String deletePaymentType(@PathVariable("paymentTypeId") int paymentTypeId, Model model) {
        paymentTypeService.deletePaymentType(paymentTypeId);
        model.addAttribute("message", "Your payment type is deleted!");
        return "redirect:/app/payment_type";
    }
}
