package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Payment;
import com.sda.onlineinvoicing.entity.User;

import java.util.List;

public interface PaymentService {

    List<Payment> getAllPayments(User user);

    void savePayment(Payment payment);

    void deletePayment(int paymentId);

    Payment getPaymentById(int paymentId);
}