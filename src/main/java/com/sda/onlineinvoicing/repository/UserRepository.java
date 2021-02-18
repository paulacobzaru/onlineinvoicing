package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//NOTE repository annotation is forgotten
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByAccountNumber(String accountNumber);
}