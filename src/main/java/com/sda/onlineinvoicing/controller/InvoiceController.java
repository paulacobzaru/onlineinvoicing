package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Invoice;
import com.sda.onlineinvoicing.entity.InvoiceLine;
import com.sda.onlineinvoicing.entity.UnitType;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Controller
public class InvoiceController {

    @Autowired
    UserService userService;

    @Autowired
    ClientService clientService;

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    CustomerServiceService customerServiceService;

    @Autowired
    ProductService productService;

    @Autowired
    UnitTypeService unitTypeService;

    @Autowired
    InvoiceLineService invoiceLineService;

    @Autowired
    VatRateService vatRateService;

    @GetMapping("/app/invoices")
    public String invoice(Model model) {
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("cityList", cityService.getAllCities());
        model.addAttribute("countryList", countryService.getAllCountries());
        model.addAttribute("currencyList", currencyService.getAllCurrencies());
        model.addAttribute("invoiceList", invoiceService.getAllInvoices());
        return "/app/invoices";
    }

    @PostMapping("/app/saveInvoice")
    public String saveInvoice(Model model, Invoice invoice) {
        //if user is free trial user
        //check count of invoices already issued
        //if its more than 100 than dont save invoice and thrwo error
        //show a meesage to customer
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByEmail(userName);
        invoice.setUser(user);
        invoiceService.saveInvoice(invoice);
        model.addAttribute("invoice", invoice);
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setInvoice(invoice);
        model.addAttribute("invoiceLine", invoiceLine);
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(user));
        model.addAttribute("productList", productService.getAllProducts());
        List<InvoiceLine> invoiceLines = invoiceLineService.getInvoiceLinesByInvoiceId(invoice.getInvoiceId());
        model.addAttribute("invoiceLineList", invoiceLines);
        Function<InvoiceLine, BigDecimal> totalMapper = line -> line.getQuantity();
        BigDecimal sumQuantities = invoiceLines.stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalQuantity", sumQuantities);
        return "/app/invoiceLine";
    }

    @GetMapping("/app/invoices/edit/{invoiceId}")
    public String getInvoice(@PathVariable("invoiceId") int invoiceId, Model model) {
        model.addAttribute("invoice", invoiceService.getInvoiceById(invoiceId));
        model.addAttribute("clientList", clientService.getAllClients());
        model.addAttribute("invoiceList", invoiceService.getAllInvoices());
        return "/app/invoices";
    }

    @GetMapping("/app/invoices/delete/{invoiceId}")
    public String deleteInvoice(@PathVariable("invoiceId") int invoiceId, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("invoice", invoiceService.getInvoiceById(invoiceId));
        invoiceService.deleteInvoice(invoiceId);
        model.addAttribute("message", "Your invoice is deleted!");
        return "redirect:/app/invoices";
    }

    @PostMapping("/app/saveInvoiceLine")
    public String saveInvoiceLine(Model model, InvoiceLine invoiceLine) {
        int unitTypeId;
        if(invoiceLine.getCustomerService()!=null){
            unitTypeId=invoiceLine.getCustomerService().getUnitType().getUnitTypeId();
            invoiceLine.setVatRate(invoiceLine.getCustomerService().getVatRate().getVatRate());
        }else{
            unitTypeId=invoiceLine.getProduct().getUnitType().getUnitTypeId();
            invoiceLine.setVatRate(invoiceLine.getProduct().getVatRate().getVatRate());
        }
        UnitType unitType = unitTypeService.getUnitTypeById(unitTypeId);
        invoiceLine.setUnitType(unitType);
        invoiceLineService.saveInvoiceLine(invoiceLine);
        InvoiceLine newInvoiceLine = new InvoiceLine();
        newInvoiceLine.setInvoice(invoiceLine.getInvoice());
        model.addAttribute("invoiceLine", newInvoiceLine);
        Invoice invoice = invoiceService.getInvoiceById(invoiceLine.getInvoice().getInvoiceId());
        model.addAttribute("invoice", invoice);
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("message", "Your invoice line is saved");
        model.addAttribute("invoiceLineList", invoiceLineService.getInvoiceLinesByInvoiceId(invoice.getInvoiceId()));
        Function<InvoiceLine, BigDecimal> totalMapper = line -> line.getQuantity();
        return "redirect:/app/invoiceLine/" + invoiceLine.getInvoice().getInvoiceId();
    }

    @GetMapping("/app/invoiceLine/delete/{invoiceId}/{invoiceLineId}")
    public String deleteInvoiceLine(@PathVariable("invoiceId") int invoiceId, @PathVariable("invoiceLineId") int invoiceLineId, Model model, RedirectAttributes redirectAttributes) {
        invoiceLineService.deleteInvoiceLine(invoiceLineId);
        redirectAttributes.addFlashAttribute("message", "Your invoice line is deleted!");
        return "redirect:/app/invoiceLine/" + invoiceId;
    }

    @GetMapping("/app/invoiceLine/{invoiceId}")
    public String invoiceLine(@PathVariable(value = "invoiceId", required = false) String invoiceIdParameter, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(Integer.parseInt(invoiceIdParameter));
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setInvoice(invoice);
        model.addAttribute("invoiceLine", invoiceLine);
        model.addAttribute("invoice", invoice);
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("productList", productService.getAllProducts());
        List<InvoiceLine> invoiceLines = invoiceLineService.getInvoiceLinesByInvoiceId(invoice.getInvoiceId());
        model.addAttribute("invoiceLineList", invoiceLines);
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());//model.addAttribute("unitTypeList",fill unit type list here);
        //HOMEWORK fill correct values/ calculated values
        //you need to get from db or you need to calculate here from invoicelines
        Function<InvoiceLine, BigDecimal> totalMapperValues = line -> line.getQuantity().multiply(line.getPrice());
        BigDecimal sumValues = invoiceLines.stream()
                .map(totalMapperValues)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Function<InvoiceLine, BigDecimal> totalMapperVat = line -> line.getQuantity().multiply(line.getPrice()).multiply(line.getVatRate()).divide(new BigDecimal("100"));
        BigDecimal sumVat = invoiceLines.stream()
                .map(totalMapperVat)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Function<InvoiceLine, BigDecimal> totalMapperTotal = line -> (line.getQuantity().multiply(line.getPrice())).add(line.getQuantity().multiply(line.getPrice()).multiply(line.getVatRate()).divide(new BigDecimal("100")));
        BigDecimal sumTotal = invoiceLines.stream()
                .map(totalMapperTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalValue", sumValues);
        model.addAttribute("totalVat", sumVat);
        model.addAttribute("totalSum", sumTotal);
        return "/app/invoiceLine";

    }

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByEmail(userName);
        return user;
    }

    @GetMapping("/app/invoiceLine/edit/{invoiceLineId}")
    public String editInvoiceLine(@PathVariable("invoiceLineId") int invoiceLineId, Model model) {
        InvoiceLine invoiceLine = invoiceLineService.getInvoiceLineById(invoiceLineId);
        model.addAttribute("invoiceLine", invoiceLine);
        Invoice invoice = invoiceLine.getInvoice();
        model.addAttribute("invoice", invoice);
        model.addAttribute("invoiceList", invoiceService.getAllInvoices());
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("customerServiceList", customerServiceService.getAllCustomerServices(getUser()));
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("invoiceLineList", invoiceLineService.getInvoiceLinesByInvoiceId(invoice.getInvoiceId()));
        return "/app/invoiceLine";
    }
}
