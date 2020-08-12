package com.example.webclientmysql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_short_name")
    private String productShortName;
    @Column(name="product_full_name")
    private String productFullName;
    @OneToMany(mappedBy = "productShortName")
    private Set<CounterpartyProduct> copros = new HashSet<>();

    public Product() {
    }

    public Product(String productShortName, String productFullName) {
        this.productShortName = productShortName;
        this.productFullName = productFullName;
    }

    public String getProductShortName() {
        return productShortName;
    }

    public void setProductShortName(String productShortName) {
        this.productShortName = productShortName;
    }

    public String getProductFullName() {
        return productFullName;
    }

    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

    public Set<CounterpartyProduct> getCopros() {
        return copros;
    }

    public void setCopros(Set<CounterpartyProduct> copros) {
        this.copros = copros;
    }
}
