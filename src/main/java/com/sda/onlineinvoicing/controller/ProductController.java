package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.entity.Product;
import com.sda.onlineinvoicing.service.ProductReportService;
import com.sda.onlineinvoicing.service.ProductService;
import com.sda.onlineinvoicing.service.UnitTypeService;
import com.sda.onlineinvoicing.service.VatRateService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;

@Controller
public class ProductController {
    @Autowired
    private ProductReportService productReportService;
    @Autowired
    UnitTypeService unitTypeService;

    @Autowired
    ProductService productService;

    @Autowired
    VatRateService vatRateService;

    @GetMapping("/app/products")
    public String products(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/products";
    }

    @PostMapping("/app/saveProduct")
    public String saveProduct(Model model, Product product){
        productService.saveProduct(product);
        model.addAttribute("product", new Product());
        model.addAttribute("message", "Your product is saved!");
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/products";
    }

    @GetMapping("/app/products/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId, Model model){
        productService.deleteProduct(productId);
        model.addAttribute("message", "Your product is deleted!");
        return "redirect:/app/products";
    }

    @GetMapping("/app/products/edit/{productId}")
    public String editProduct(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        model.addAttribute("unitTypeList", unitTypeService.getAllUnitTypes());
        model.addAttribute("productList", productService.getAllProducts());
        model.addAttribute("vatRateList", vatRateService.getAllVatRates());
        return "/app/products";
    }

}
