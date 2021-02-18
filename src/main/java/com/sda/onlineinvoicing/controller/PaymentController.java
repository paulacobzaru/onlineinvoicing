package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Payment;
import com.sda.onlineinvoicing.service.ClientService;
import com.sda.onlineinvoicing.service.PaymentService;
import com.sda.onlineinvoicing.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ClientService clientService;

    @Autowired
    PaymentTypeService paymentTypeService;

    @GetMapping("/app/payments")
    public String invoices(Model model) {
        model.addAttribute("payment", new Payment());
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        model.addAttribute("paymentList", paymentService.getAllPayments());
        return "/app/payments";
    }

    @PostMapping("/app/savePayment")
    public String savePayment(Model model, Payment payment) {
        paymentService.savePayment(payment);
        model.addAttribute("payment", new Payment());
        model.addAttribute("message", "Your payment is created!");
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("paymentList", paymentService.getAllPayments());
        return "/app/payments";
    }

    @GetMapping("/app/payments/delete/{paymentId}")
    public String deletePayment(@PathVariable("paymentId") int paymentId, Model model) {
        paymentService.deletePayment(paymentId);
        model.addAttribute("message", "Your payment is deleted!");
        return "redirect:/app/payments";
    }

    @GetMapping("/app/payments/edit/{paymentId}")
    public String getPayment(@PathVariable("paymentId") int paymentId, Model model) {
        model.addAttribute("payment", paymentService.getPaymentById(paymentId));
        model.addAttribute("paymentTypeList", paymentTypeService.getAllPaymentTypes());
        model.addAttribute("productList", paymentService.getAllPayments());
        model.addAttribute("clientList", clientService.getAllClients());
        return "/app/payments";
    }

}
