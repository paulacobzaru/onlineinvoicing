package com.sda.onlineinvoicing.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int invoiceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId")
    private Client client;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date invoiceDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date dueDate;

    @Column(length = 500)
    private String supplierNotes;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getSupplierNotes() {
        return supplierNotes;
    }

    public void setSupplierNotes(String supplierNotes) {
        this.supplierNotes = supplierNotes;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", user=" + user +
                ", client=" + client +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", supplierNotes='" + supplierNotes + '\'' +
                '}';
    }
}
