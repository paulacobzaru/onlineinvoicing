package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    //NOTE autowired objects should be public
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //TODO saveService is forgotten
    //TODO we should discuss naming of Service class
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
