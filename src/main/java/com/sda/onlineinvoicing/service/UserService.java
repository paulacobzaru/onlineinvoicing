package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Client;
import com.sda.onlineinvoicing.entity.Currency;
import com.sda.onlineinvoicing.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    User findByEmail(String email);
}
