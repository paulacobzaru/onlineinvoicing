package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();

    void savePayment(Payment payment);

    void deletePayment(int paymentId);

    Payment getPaymentById(int paymentId);
}