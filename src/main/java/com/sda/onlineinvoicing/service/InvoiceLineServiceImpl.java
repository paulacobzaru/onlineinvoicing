package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.InvoiceLine;
import com.sda.onlineinvoicing.repository.InvoiceLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService {

    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    @Override
    public List<InvoiceLine> getAllInvoiceLines() {
        return invoiceLineRepository.findAll();
    }

    @Override
    public void saveInvoiceLine(InvoiceLine invoiceLine) {
        invoiceLineRepository.save(invoiceLine);
    }

    @Override
    public void deleteInvoiceLine(int invoiceLineId) {
        invoiceLineRepository.deleteById(invoiceLineId);
    }

    @Override
    public InvoiceLine getInvoiceLineById(int invoiceLineId) {
        return invoiceLineRepository.findById(invoiceLineId).orElse(new InvoiceLine());
    }

    @Override
    public List<InvoiceLine> getInvoiceLinesByInvoiceId(int invoiceId) {
        return invoiceLineRepository.findByInvoiceId(invoiceId);
    }


}
