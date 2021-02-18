package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.CustomerService;

import java.util.List;

public interface CustomerServiceService {

    List<CustomerService> getAllCustomerServices();

    //TODO method should be in interface
    void saveCustomerService(CustomerService customerService);

    void deleteCustomerService(int serviceId);

    CustomerService getCustomerServiceById(int serviceId);
}
