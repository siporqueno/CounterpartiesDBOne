package com.example.webclientmysql.repositories;

import com.example.webclientmysql.entities.Counterparty;
import com.example.webclientmysql.entities.CounterpartyId;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called counterpartyRepository
// CRUD refers Create, Read, Update, Delete

public interface CounterpartyRepository extends JpaRepository<Counterparty, CounterpartyId> {
}
