package com.example.webclientmysql;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called counterpartyProductRepository
// CRUD refers Create, Read, Update, Delete

public interface CounterpartyProductRepository extends CrudRepository<CounterpartyProduct, CounterpartyProductId> {
List<CounterpartyProduct> findCounterpartyProductsByProductShortName(String productShortName);
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyShortName(String counterpartyShortName);
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyShortNameOrProductShortName(String counterpartyShortName, String productShortName);
List<CounterpartyProduct> findCounterpartyProductsByCounterpartyShortNameAndProductShortName(String counterpartyShortName, String productShortName);
}
