package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.InvoiceLine;

import java.util.List;
public interface InvoiceLineService {
    List<InvoiceLine> getAllInvoiceLines();

    void saveInvoiceLine(InvoiceLine invoiceLine);

    void deleteInvoiceLine(int invoiceLineId);

    InvoiceLine getInvoiceLineById(int invoiceLineId);

    List<InvoiceLine> getInvoiceLinesByInvoiceId(int invoiceId);
}
