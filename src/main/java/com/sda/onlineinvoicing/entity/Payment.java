package com.sda.onlineinvoicing.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentType")
    private PaymentType paymentType;

    @Column
    private BigDecimal valuePaid;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getValuePaid() {
        return valuePaid;
    }

    public void setValuePaid(BigDecimal valuePaid) {
        this.valuePaid = valuePaid;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", client=" + client +
                ", paymentType=" + paymentType +
                ", valuePaid=" + valuePaid +
                '}';
    }
}
