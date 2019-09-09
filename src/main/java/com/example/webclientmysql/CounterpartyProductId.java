package com.example.webclientmysql;

import java.io.Serializable;

public class CounterpartyProductId implements Serializable {
    private String counterpartyShortName;
    private String productShortName;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        CounterpartyProductId another = (CounterpartyProductId) obj;
        return this.counterpartyShortName.equals(another.counterpartyShortName) && this.productShortName.equals(another.productShortName);
    }

    @Override
    public int hashCode() {
        return counterpartyShortName.hashCode()+productShortName.hashCode();
    }

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
}
