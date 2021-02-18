package com.sda.onlineinvoicing.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="vat_rate")
public class VatRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int vatRateId;

    @Column
    private BigDecimal vatRate;

    public int getVatRateId() {
        return vatRateId;
    }

    public void setVatRateId(int vatRateId) {
        this.vatRateId = vatRateId;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return "VatRate{" +
                "vatRateId=" + vatRateId +
                ", vatRate=" + vatRate +
                '}';
    }
}
