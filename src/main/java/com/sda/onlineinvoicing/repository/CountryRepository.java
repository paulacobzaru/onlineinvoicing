package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> { //entity, primary key

}
