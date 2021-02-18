package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//NOTE repository annotation is forgotten
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
