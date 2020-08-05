package com.example.webclientmysql.repositories;

import com.example.webclientmysql.entities.CounterpartyProduct;
import com.example.webclientmysql.entities.CounterpartyProductId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// This will be AUTO IMPLEMENTED by Spring into a Bean called counterpartyProductRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface CounterpartyProductRepository extends CrudRepository<CounterpartyProduct, CounterpartyProductId> {
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyId(Integer counterpartyId);
List<CounterpartyProduct> findCounterpartyProductsByProductShortName(String productShortName);
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyIdOrProductShortName(Integer counterpartyId, String productShortName);
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyIdAndProductShortName(Integer counterpartyId, String productShortName);
}
