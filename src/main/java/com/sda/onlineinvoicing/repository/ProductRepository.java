package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Product;
import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> { //TODO entity type is forgotten
    List<Product> findByUser(User user);
}

