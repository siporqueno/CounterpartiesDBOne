package com.example.webclientmysql.entities;

import java.io.Serializable;

public class CounterpartyProductId implements Serializable {
    private String counterpartyShortName;
    private String countryCode;
    private String place;
    private String productShortName;

    public CounterpartyProductId(String counterpartyShortName, String countryCode, String place, String productShortName) {
        this.counterpartyShortName = counterpartyShortName;
        this.countryCode = countryCode;
        this.place = place;
        this.productShortName = productShortName;
    }

    public CounterpartyProductId() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        CounterpartyProductId another = (CounterpartyProductId) obj;
        return this.counterpartyShortName.equals(another.counterpartyShortName) && this.countryCode.equals(another.countryCode) &&
                this.place.equals(another.place) && this.productShortName.equals(another.productShortName);
    }

    @Override
    public int hashCode() {
        return counterpartyShortName.hashCode() + countryCode.hashCode() +
                place.hashCode() + productShortName.hashCode();
    }

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
}
