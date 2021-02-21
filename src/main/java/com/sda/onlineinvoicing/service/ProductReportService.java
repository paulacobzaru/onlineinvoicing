package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Product;
import com.sda.onlineinvoicing.repository.ProductRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductReportService {
    @Autowired
    private ProductRepository productRepository;

    public String exportProductReport(String productReportFormat) throws FileNotFoundException, JRException {
        String path = "D:\\Reports\\";
        List<Product> product = productRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("src/main/resources/templates/reports/products.jrxml");
        JasperReport jasperProductReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(product);
        Map<String, Object> map = new HashMap<>();
        map.put("createdBy", "OIL");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperProductReport, map, dataSource);
        String reportMessage = "Report generated in path: " + path;
        if (productReportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "products.html");
            reportMessage = reportMessage + "products.html";
        }
        if (productReportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "products.pdf");
            reportMessage = reportMessage + "products.pdf";
        }
        return reportMessage;
    }

    public String exportInvoiceReport(String invoiceId) {
        return null;
    }
}
