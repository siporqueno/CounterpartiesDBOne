package com.example.webclientmysql.entities;

import java.io.Serializable;

public class CounterpartyId implements Serializable {
    private String counterpartyShortName;
    private String countryCode;
    private String place;

    public CounterpartyId(String counterpartyShortName, String countryCode, String place) {
        this.counterpartyShortName = counterpartyShortName;
        this.countryCode = countryCode;
        this.place = place;
    }

    public CounterpartyId() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        CounterpartyId another = (CounterpartyId) obj;
        return this.counterpartyShortName.equals(another.counterpartyShortName) && this.countryCode.equals(another.countryCode) && this.place.equals(another.place);
    }

    @Override
    public int hashCode() {
        return counterpartyShortName.hashCode()+countryCode.hashCode()+place.hashCode();
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
}
