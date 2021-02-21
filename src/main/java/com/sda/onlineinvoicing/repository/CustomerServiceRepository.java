package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.CustomerService;
import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Integer> {//TODO entity type is forgotten

    List<CustomerService> findByUser(User user);
}
