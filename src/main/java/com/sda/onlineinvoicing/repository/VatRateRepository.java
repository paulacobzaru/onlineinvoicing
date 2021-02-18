package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.VatRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatRateRepository extends JpaRepository<VatRate, Integer> {
}
