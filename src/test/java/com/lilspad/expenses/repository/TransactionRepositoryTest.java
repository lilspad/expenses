package com.lilspad.expenses.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.lilspad.expenses.model.Transaction;

@DataJpaTest
class TransactionRepositoryTest {

  @Autowired
  TransactionRepository repo;

  @Test
  void entityPersistsAndGetsAnId() {
    Transaction saved = repo.save(
        new Transaction(LocalDate.of(2026, 11, 22), new BigDecimal("-9.99"), "Spotify"));
    assertThat(saved.getId()).isNotNull();
  }
}