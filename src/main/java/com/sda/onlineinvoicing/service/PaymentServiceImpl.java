package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Payment;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;


    @Override
    public List<Payment> getAllPayments(User user) {
        return paymentRepository.findByUser(user);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(int paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(new Payment());
    }

}
