package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Invoice;
import com.sda.onlineinvoicing.entity.InvoiceLine;
import com.sda.onlineinvoicing.entity.User;
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
public class InvoiceReportService {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    InvoiceLineService invoiceLineService;

    public String createInvoiceReport(String invoiceId, String format) throws FileNotFoundException, JRException {
        String path = "D:\\Reports\\";
        Invoice invoice = invoiceService.getInvoiceById(Integer.parseInt(invoiceId));
        List<InvoiceLine> invoiceLines = invoiceLineService.getInvoiceLinesByInvoiceId(Integer.parseInt(invoiceId));

        File file = ResourceUtils.getFile("src/main/resources/templates/reports/invoice.jrxml");
        JasperReport jasperProductReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceLines);
        Map<String, Object> map = new HashMap<>();
        User user = invoice.getUser();
        map.put("userName", user.getCompanyName());
        map.put("vatNumber", user.getVatNumber());
        map.put("address", user.getAddress3());
        map.put("zipCode", user.getZipCode1());
        map.put("city", user.getCity().getCityName());
        map.put("country", user.getCountry().getCountryName());
        map.put("bank", user.getBank());
        map.put("email", user.getEmail());
        map.put("client",invoice.getClient());
        map.put("invoiceDate",invoice.getInvoiceDate());
        map.put("invoiceNumber",invoice.getInvoiceId());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperProductReport, map, dataSource);
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "invoice_id_" + invoiceId + ".html");
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "invoice_id_" + invoiceId + ".pdf");
        }
        return "Report generated in path: " + path;
    }

}
