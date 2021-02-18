package com.sda.onlineinvoicing.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment_type")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int paymentTypeId;

    @Column(length = 50)
    private String paymentType;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "paymentTypeId=" + paymentTypeId +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
