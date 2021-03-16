package com.sda.onlineinvoicing.repository;

import com.sda.onlineinvoicing.entity.Client;
import com.sda.onlineinvoicing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByUser(User user);
}
