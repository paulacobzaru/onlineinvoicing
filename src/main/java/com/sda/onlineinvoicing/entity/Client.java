package com.sda.onlineinvoicing.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int clientId;

    @Column(length = 200)
    private String clientName;

    @Column(length = 50)
    private String vatNumber;

    @Column(length = 50)
    private String telephone;

    @Column(length = 200)
    private String email;

    @Column(length = 200)
    private String website;

    @Column(length = 200)
    private String address1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId")
    private Country country;

    @Column(length = 50)
    private String zipCode;

    @Column(length = 100)
    private String bank;

    @Column(length = 100)
    private String accountNumber;

    @Column(length = 50)
    private String accountSortCode;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountSortCode() {
        return accountSortCode;
    }

    public void setAccountSortCode(String accountSortCode) {
        this.accountSortCode = accountSortCode;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", address1='" + address1 + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", zipCode='" + zipCode + '\'' +
                ", bank='" + bank + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountSortCode='" + accountSortCode + '\'' +
                '}';
    }
}
