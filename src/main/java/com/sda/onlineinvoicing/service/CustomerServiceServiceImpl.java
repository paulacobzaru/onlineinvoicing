package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.CustomerService;
import com.sda.onlineinvoicing.repository.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Override
    public List<CustomerService> getAllCustomerServices() {
        return customerServiceRepository.findAll();
    }

    //TODO saveService is forgotten
    //TODO we should discuss naming of Service class
    @Override
    public void saveCustomerService(CustomerService customerService) {
        customerServiceRepository.save(customerService);
    }

    @Override
    public void deleteCustomerService(int serviceId) {
        customerServiceRepository.deleteById(serviceId);
    }

    @Override
    public CustomerService getCustomerServiceById(int serviceId) {
        return customerServiceRepository.findById(serviceId).orElse(new CustomerService());
    }
}