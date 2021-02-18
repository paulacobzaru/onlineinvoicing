package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//NOTE repository annotation is forgotten
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
    Authority findByName(String name);
}
