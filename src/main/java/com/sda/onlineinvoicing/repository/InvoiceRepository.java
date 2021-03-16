package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Invoice;
import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//NOTE repository annotation is forgotten
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByUser(User user);
}
