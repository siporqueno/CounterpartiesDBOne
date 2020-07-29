package com.example.webclientmysql.entities;

import javax.persistence.*;

@Entity
@IdClass(CounterpartyId.class)
@Table(name = "counterparties")
public class Counterparty {
    @Id
    @Column(name = "counterparty_short_name")
    private String counterpartyShortName;
    @Id
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "region")
    private String region;
    @Id
    @Column(name="place")
    private String place;

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
