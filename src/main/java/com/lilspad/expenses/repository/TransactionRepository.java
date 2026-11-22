package com.lilspad.expenses.repository;

import com.lilspad.expenses.model.Transaction;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
