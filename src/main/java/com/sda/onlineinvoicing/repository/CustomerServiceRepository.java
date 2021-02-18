package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService,Integer> {//TODO entity type is forgotten
}
