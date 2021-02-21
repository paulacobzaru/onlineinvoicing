package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.CustomerService;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.service.CustomerServiceService;
import com.sda.onlineinvoicing.service.UnitTypeService;
import com.sda.onlineinvoicing.service.UserService;
import com.sda.onlineinvoicing.service.VatRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerServiceController {

    @Autowired
    UnitTypeService unitTypeService;

    @Autowired
    CustomerServiceService customerServiceService;

    @Autowired
    VatRateService vatRateService;

    @Autowired
    UserService userService;

    @GetMapping("/app/services")
    public String services(Model model) {
        model.addAttribute("customerService", new CustomerService());
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/services";
    }

    @PostMapping("/app/saveCustomerService")
    public String saveCustomerService(Model model, CustomerService customerService) {
        customerService.setUser(getUser());
        customerServiceService.saveCustomerService(customerService);
        model.addAttribute("customerService", new CustomerService());
        model.addAttribute("message", "Your service is saved!");
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/services";
    }

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByEmail(userName);
        return user;
    }

    @GetMapping("/app/services/edit/{serviceId}")
    public String editService(@PathVariable("serviceId") int serviceId, Model model) {
        model.addAttribute("customerService", customerServiceService.getCustomerServiceById(serviceId));
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/services";
    }

    @GetMapping("/app/services/delete/{serviceId}")
    public String deleteService(@PathVariable("serviceId") int serviceId, Model model) {
        customerServiceService.deleteCustomerService(serviceId);
        model.addAttribute("message", "Your service is deleted!");
        return "redirect:/app/services";
    }
}
