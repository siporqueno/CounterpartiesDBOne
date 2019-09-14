package com.example.webclientmysql;

import javax.persistence.*;

@Entity
@IdClass(CounterpartyProductId.class)
@Table(name = "counterparties_products")
public class CounterpartyProduct {
    @Id
    @Column(name = "CounterpartyShortName")
    private String counterpartyShortName;
    @Id
    @Column(name = "ProductShortName")
    private String productShortName;
    @Column(name = "IsBuyer")
    private boolean isBuyer;
    @Column(name = "IsSeller")
    private boolean isSeller;
    @Column(name = "IsConsumer")
    private boolean isConsumer;
    @Column(name = "IsProducer")
    private boolean isProducer;
    @Column(name = "Quantity")
    private String quantity;

    public String getCounterpartyShortName() {
        return counterpartyShortName;
    }

    public void setCounterpartyShortName(String counterpartyShortName) {
        this.counterpartyShortName = counterpartyShortName;
    }

    public String getProductShortName() {
        return productShortName;
    }

    public void setProductShortName(String productShortName) {
        this.productShortName = productShortName;
    }

    public boolean getIsBuyer() {
        return isBuyer;
    }

    public void setIsBuyer(boolean isBuyer) {
        this.isBuyer = isBuyer;
    }

    public boolean getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(boolean isSeller) {
        this.isSeller = isSeller;
    }

    public boolean getIsConsumer() {
        return isConsumer;
    }

    public void setIsConsumer(boolean isConsumer) {
        this.isConsumer = isConsumer;
    }

    public boolean getIsProducer() {
        return isProducer;
    }

    public void setIsProducer(boolean isProducer) {
        this.isProducer = isProducer;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
