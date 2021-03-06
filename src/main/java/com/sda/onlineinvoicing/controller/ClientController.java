package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Client;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.service.CityService;
import com.sda.onlineinvoicing.service.ClientService;
import com.sda.onlineinvoicing.service.CountryService;
import com.sda.onlineinvoicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @GetMapping("/app/clients")
    public String clients(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("clientList", clientService.getAllClients(getUser()));
        return "/app/clients";
    }

    @PostMapping("/app/saveClient")
    public String saveClient(Model model, Client client) {
        client.setUser(getUser());
        clientService.saveClient(client);
        model.addAttribute("client", new Client());
        model.addAttribute("message", "Your client is saved!");
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("clientList", clientService.getAllClients(getUser()));
        return "/app/clients";
    }

    @GetMapping("/app/clients/delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") int clientId, Model model){
        clientService.deleteClient(clientId);
        model.addAttribute("message", "Your client is deleted!");
        return "redirect:/app/clients";
    }

    @GetMapping("/app/clients/edit/{clientId}")
    public String editClient(@PathVariable("clientId") int clientId, Model model){
        model.addAttribute("client", clientService.getClientById(clientId));
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("clientList", clientService.getAllClients(getUser()));
        return "/app/clients";
    }

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByEmail(userName);
        return user;
    }

}
