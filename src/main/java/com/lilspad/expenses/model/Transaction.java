package com.lilspad.expenses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private LocalDate date;
  private BigDecimal amount;
  private String description;

  protected Transaction() {};

  public Transaction(LocalDate date, BigDecimal amount, String description) {
    this.date = date;
    this.amount = amount;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format(
      "Transaction[id=%d, date=%s, amount=%s, description=%s]",
      id, date, amount, description
    );
  }

  public LocalDate getDate() {
    return date;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }
}
