package com.example.webclientmysql.entities;

import javax.persistence.*;

@Entity
@IdClass(CounterpartyProductId.class)
@Table(name = "counterparties_products")
public class CounterpartyProduct {
    @Id
    @Column(name = "counterparty_short_name")
    private String counterpartyShortName;
    @Id
    @Column(name="country_code")
    private String countryCode;
    @Id
    @Column(name="place")
    private String place;
    @Id
    @Column(name = "product_short_name")
    private String productShortName;
    @Column(name = "is_buyer")
    private boolean isBuyer;
    @Column(name = "is_seller")
    private boolean isSeller;
    @Column(name = "is_consumer")
    private boolean isConsumer;
    @Column(name = "is_producer")
    private boolean isProducer;
    @Column(name = "quantity")
    private String quantity;

    public String getCounterpartyShortName() {
        return counterpartyShortName;
    }

    public void setCounterpartyShortName(String counterpartyShortName) {
        this.counterpartyShortName = counterpartyShortName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
