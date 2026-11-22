package com.lilspad.expenses.repository;

import com.lilspad.expenses.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
