package com.sda.onlineinvoicing.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="invoice_line")
public class InvoiceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int invoiceLineId;

    @OneToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    @Column(length = 50)
    private String invoiceLineType;

    @OneToOne
    @JoinColumn(name="productId")
    private Product product;

    @OneToOne
    @JoinColumn(name="serviceId")
    private CustomerService customerService;

    @OneToOne
    @JoinColumn(name="unit_type")
    private UnitType unitType;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private BigDecimal vatRate;

    public int getInvoiceLineId() {
        return invoiceLineId;
    }

    public void setInvoiceLineId(int invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceLineType() {
        return invoiceLineType;
    }

    public void setInvoiceLineType(String invoiceLineType) {
        this.invoiceLineType = invoiceLineType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }

    public void setVatRate(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "invoiceLineId=" + invoiceLineId +
                ", invoice=" + invoice +
                ", invoiceLineType='" + invoiceLineType + '\'' +
                ", product=" + product +
                ", customerService=" + customerService +
                ", unitType=" + unitType +
                ", quantity=" + quantity +
                ", price=" + price +
                ", vatRate=" + vatRate +
                '}';
    }
}
