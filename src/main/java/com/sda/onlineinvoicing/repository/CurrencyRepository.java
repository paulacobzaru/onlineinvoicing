package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//NOTE repository annotation is forgotten
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
