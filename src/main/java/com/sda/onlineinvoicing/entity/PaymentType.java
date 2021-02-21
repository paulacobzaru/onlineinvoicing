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
    private String paymentTypeName;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "paymentTypeId=" + paymentTypeId +
                ", paymentTypeName='" + paymentTypeName + '\'' +
                '}';
    }
}
