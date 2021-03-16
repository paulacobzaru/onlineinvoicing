package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Invoice;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImlp implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;


    @Override
    public List<Invoice> getAllInvoices(User user) {
        return invoiceRepository.findByUser(user);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(int invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }

    @Override
    public Invoice getInvoiceById(int invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(new Invoice());
    }
}
