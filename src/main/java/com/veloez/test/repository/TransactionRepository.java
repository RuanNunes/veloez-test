package com.veloez.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veloez.test.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
