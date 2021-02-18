package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.PaymentType;
import com.sda.onlineinvoicing.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public void savePaymentType(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);
    }

    @Override
    public void deletePaymentType(int paymentTypeId) {
paymentTypeRepository.deleteById(paymentTypeId);
    }

    @Override
    public PaymentType getPaymentTypeById(int paymentTypeId) {
        return paymentTypeRepository.findById(paymentTypeId).orElse(new PaymentType());
    }
}
