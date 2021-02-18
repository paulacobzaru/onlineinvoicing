package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Authority;
import com.sda.onlineinvoicing.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Override
    public Authority getAuthorities(String name) {
        return authoritiesRepository.findByName(name);
    }
}
