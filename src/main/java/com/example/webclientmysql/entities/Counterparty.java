package com.example.webclientmysql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "counterparties")
public class Counterparty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "counterparty_short_name")
    private String counterpartyShortName;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "region")
    private String region;
    @Column(name = "place")
    private String place;
    @OneToMany(mappedBy = "counterpartyId")
    private Set<CounterpartyProduct> copros = new HashSet<>();

    public Counterparty() {
    }

    public Counterparty(Integer id, CounterpartyId coId) {
        this.id = id;
        this.counterpartyShortName = coId.getCounterpartyShortName();
        this.countryCode = coId.getCountryCode();
        this.place = coId.getPlace();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<CounterpartyProduct> getCopros() {
        return copros;
    }

    public void setCopros(Set<CounterpartyProduct> copros) {
        this.copros = copros;
    }
}
