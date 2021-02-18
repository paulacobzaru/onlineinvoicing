package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.List;
//NOTE repository annotation is forgotten
@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Integer> {

    @Query(value = "select * from invoice_line where invoice_id = ?1", nativeQuery = true)
    List<InvoiceLine> findByInvoiceId(int invoiceId);


}
