package com.sda.onlineinvoicing.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_service")
public class CustomerService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int serviceId;

    @Column(length = 200)
    private String serviceName; //training

    @OneToOne
    @JoinColumn
    private VatRate vatRate;

    @OneToOne
    @JoinColumn(name = "unitTypeId")
    public UnitType unitType; //hours

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", vatRate=" + vatRate +
                ", unitType=" + unitType +
                ", user=" + user +
                '}';
    }
}
