package com.sda.onlineinvoicing.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int userId;

    @Email
    @Column(nullable = false)
    private String email;

    //@Constraint//(validatedBy = PasswordConstraintValidator.class) + https://stackabuse.com/spring-custom-password-validation/
    @Column(nullable = false)
    private String password;//what annotation must have?

    @Column(length = 200)
    private String companyName;

    @Column(length = 100)
    private String vatNumber;

    @Column(length = 200)
    private String address3;

    @Column(length = 50)
    private String zipCode1;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId")
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currencyId")
    private Currency currency;

    @Column(length = 100)
    private String bank;

    @Column(length = 100)
    private String accountNumber;

    @Column(length = 100)
    private String sortCode;

    @Column(length = 50)
    private String telephone;

    @Column(length = 100)
    private String website;

    @OneToOne
    private Authority authority;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "roleId")
//    private Role role;


//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//
//    )
//    private Set<Authority> roles = new HashSet<>();


    @Column
    private short enabled = 1; //1 is active others passive

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getZipCode1() {
        return zipCode1;
    }

    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", address3='" + address3 + '\'' +
                ", zipCode1='" + zipCode1 + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", currency=" + currency +
                ", bank='" + bank + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", telephone='" + telephone + '\'' +
                ", website='" + website + '\'' +
                ", authority=" + authority +
                ", enabled=" + enabled +
                '}';
    }
}
