package com.sda.onlineinvoicing.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int productId;

    @Column
    private String productName; //shoes

    @OneToOne
    @JoinColumn
    private VatRate vatRate;

    @OneToOne
    @JoinColumn
    private UnitType unitType; //pair

    @Column
    private BigDecimal stock; //22

    @Column
    private BigDecimal acquisitionPrice; //20

    //the date of acuisition must not be after the date of sale
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAcquisition; //22/11/2020

    //the date of sale must not be after the due date
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate; //can be any time in the future

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public VatRate getVatRate() {
        return vatRate;
    }

    public void setVatRate(VatRate vatRate) {
        this.vatRate = vatRate;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getAcquisitionPrice() {
        return acquisitionPrice;
    }

    public void setAcquisitionPrice(BigDecimal acquisitionPrice) {
        this.acquisitionPrice = acquisitionPrice;
    }

    public Date getDateOfAcquisition() {
        return dateOfAcquisition;
    }

    public void setDateOfAcquisition(Date dateOfAcquisition) {
        this.dateOfAcquisition = dateOfAcquisition;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", vatRate=" + vatRate +
                ", unitType=" + unitType +
                ", stock=" + stock +
                ", acquisitionPrice=" + acquisitionPrice +
                ", dateOfAcquisition=" + dateOfAcquisition +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                '}';
    }
}
