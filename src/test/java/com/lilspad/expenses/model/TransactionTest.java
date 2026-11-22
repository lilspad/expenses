package com.lilspad.expenses.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {
  @Test 
  void toString_doesNotThrow() {
    String s = new Transaction(LocalDate.now(), new BigDecimal("2.00"), "Tea" ).toString();
    assertThat(s).contains("Tea");
  }
}
