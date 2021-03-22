package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Authority;

import java.util.List;

public interface AuthoritiesService {
    Authority getAuthorities(String name);
    List<Authority> getAll();
}
