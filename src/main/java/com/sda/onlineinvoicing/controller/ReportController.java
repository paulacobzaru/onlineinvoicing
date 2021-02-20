package com.sda.onlineinvoicing.controller;

import com.sda.onlineinvoicing.service.InvoiceReportService;
import com.sda.onlineinvoicing.service.ProductReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class ReportController {
    @Autowired
    private ProductReportService productReportService;
    @Autowired
    private InvoiceReportService invoiceReportService;

    @GetMapping("/report/products/{format}")
    public String generatedReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return productReportService.exportProductReport(format);
    }

    @GetMapping("/report/invoice/{format}/{invoiceId}")
    public String generatedInvoiceReport(@PathVariable String format, @PathVariable String invoiceId) throws FileNotFoundException, JRException {
        return invoiceReportService.createInvoiceReport(invoiceId, format);

    }
}
