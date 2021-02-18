package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> getAllPaymentTypes();

    void savePaymentType(PaymentType paymentType);

    void deletePaymentType(int paymentTypeId);

    PaymentType getPaymentTypeById(int paymentTypeId);
}
