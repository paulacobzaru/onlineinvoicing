package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> { //TODO entity type is forgotten
}

