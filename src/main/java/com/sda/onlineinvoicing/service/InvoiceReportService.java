package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Invoice;
import com.sda.onlineinvoicing.entity.InvoiceLine;
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

//        String reportsDirPath =getServlet().getServletContext().getRealPath("/")+"D:\\Reports\\"
//      File reportsDir = new File(reportsDirPath);
//        if (!reportsDir.exists()) {
//            try {
//                throw new FileNotFoundException(String.valueOf(reportsDir));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                map.findForward("/InternalError.do");
//            }
//        }
//
//        HashMap<String,Object> hm = new HashMap<String,Object>();
//        hm.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(reportsDir));

        File file = ResourceUtils.getFile("src/main/resources/templates/reports/invoice.jrxml");
        JasperReport jasperProductReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoiceLines);
        Map<String, Object> map = new HashMap<>();
        map.put("user", invoice.getUser());
        map.put("client",invoice.getClient());
        map.put("invoice",invoice);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperProductReport, map, dataSource);
        String message = "Report generated in path: " + path;
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "invoice_id_" + invoiceId + ".html");
            message = message + "invoice_id_" + invoiceId + ".html";
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "invoice_id_" + invoiceId + ".pdf");
            message = message + "invoice_id_" + invoiceId + ".pdf";
        }
        return message;
    }

}
