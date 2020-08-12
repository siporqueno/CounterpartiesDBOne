package com.example.webclientmysql.repositories;

import com.example.webclientmysql.entities.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called counterpartyRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, Integer> {
    Optional<Counterparty> findByCounterpartyShortNameAndCountryCodeAndPlace(String counterpartyShortName, String countryCode, String place);
    List<Counterparty> findByCounterpartyShortName(String counterpartyShortName);
    List<Counterparty> findByCountryCode(String countryCode);
    List<Counterparty> findByRegion(String region);
    List<Counterparty> findByPlace(String place);
}
