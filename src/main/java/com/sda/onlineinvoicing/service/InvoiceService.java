package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();

    void saveInvoice(Invoice invoice);

    void deleteInvoice(int InvoiceId);

    Invoice getInvoiceById(int invoiceId);

}
