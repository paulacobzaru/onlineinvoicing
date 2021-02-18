package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType,Integer> {
}
