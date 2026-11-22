package com.lilspad.expenses.service;

import com.lilspad.expenses.model.Transaction;
import com.lilspad.expenses.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

  private final TransactionRepository repository = mock(TransactionRepository.class);
  private final TransactionService service = new TransactionService(repository);

  @Test
  void add_buildsAndSavesTransaction() {
    service.add(LocalDate.of(2026, 11, 22), new BigDecimal("-12.50"), "Lidl");

    ArgumentCaptor<Transaction> captor = ArgumentCaptor.forClass(Transaction.class);
    verify(repository).save(captor.capture());

    Transaction saved = captor.getValue();
    assertThat(saved.getDate()).isEqualTo(LocalDate.of(2026, 11, 22));
    assertThat(saved.getAmount()).isEqualByComparingTo("-12.50");
    assertThat(saved.getDescription()).isEqualTo("Lidl");
  }

  @Test
  void listAll_returnsWhatTheRepoHas() {
    Transaction t = new Transaction(LocalDate.now(), new BigDecimal("2.00"), "Tea");
    when(repository.findAll()).thenReturn(List.of(t));

    assertThat(service.listAll()).hasSize(1);
  }
}