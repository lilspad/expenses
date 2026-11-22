package com.lilspad.expenses.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lilspad.expenses.model.Transaction;
import com.lilspad.expenses.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionService {

  private final TransactionRepository transactions;

  public TransactionService(TransactionRepository transactions) {
    this.transactions = transactions;
  }

  public Transaction add(LocalDate date, BigDecimal amount, String description) {
    return transactions.save(new Transaction(date, amount, description));
  }

  public List<Transaction> listAll() {
    return transactions.findAll();
  }
}
