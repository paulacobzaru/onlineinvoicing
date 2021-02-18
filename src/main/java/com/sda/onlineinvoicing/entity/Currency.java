package com.sda.onlineinvoicing.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int currencyId;

    @Column(length = 6)
    private String currencySymbol;

    @Column(length = 20)
    private String currencyName;

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId=" + currencyId +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }
}
