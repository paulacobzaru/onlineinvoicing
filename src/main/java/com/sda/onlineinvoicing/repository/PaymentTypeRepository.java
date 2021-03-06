package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
}
