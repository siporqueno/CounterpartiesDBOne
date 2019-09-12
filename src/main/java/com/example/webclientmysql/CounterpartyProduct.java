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
    private String isSeller;
    @Column(name = "IsConsumer")
    private String isConsumer;
    @Column(name = "IsProducer")
    private String isProducer;
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

    public String getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(String seller) {
        isSeller = seller;
    }

    public String getIsConsumer() {
        return isConsumer;
    }

    public void setIsConsumer(String consumer) {
        isConsumer = consumer;
    }

    public String getIsProducer() {
        return isProducer;
    }

    public void setIsProducer(String producer) {
        isProducer = producer;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
