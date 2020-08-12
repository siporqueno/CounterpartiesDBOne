package com.example.webclientmysql.entities;

import java.io.Serializable;

public class CounterpartyProductId implements Serializable {
    private Integer counterpartyId;
    private String productShortName;

    public CounterpartyProductId(Integer counterpartyId, String productShortName) {
        this.counterpartyId = counterpartyId;
        this.productShortName = productShortName;
    }

    public CounterpartyProductId() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        CounterpartyProductId another = (CounterpartyProductId) obj;

        return this.counterpartyId == another.counterpartyId && this.productShortName.equals(another.productShortName);
    }

    @Override
    public int hashCode() {
        return counterpartyId.hashCode() + productShortName.hashCode();
    }

    public Integer getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(Integer counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public String getProductShortName() {
        return productShortName;
    }

    public void setProductShortName(String productShortName) {
        this.productShortName = productShortName;
    }
}
