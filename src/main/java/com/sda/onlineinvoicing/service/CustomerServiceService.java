package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.CustomerService;
import com.sda.onlineinvoicing.entity.User;

import java.util.List;

public interface CustomerServiceService {

    List<CustomerService> getAllCustomerServices(User user);
    //TODO method should be in interface
    void saveCustomerService(CustomerService customerService);

    void deleteCustomerService(int serviceId);

    CustomerService getCustomerServiceById(int serviceId);
}
