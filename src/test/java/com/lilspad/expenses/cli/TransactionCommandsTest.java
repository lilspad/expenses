package com.lilspad.expenses.cli;

import com.lilspad.expenses.model.Transaction;
import com.lilspad.expenses.service.TransactionService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionCommandsTest {

  private final TransactionService service = mock(TransactionService.class);
  private final TransactionCommands commands = new TransactionCommands(service);

  @Test
  void add_parsesInputsAndCallsService() {
    Transaction t = new Transaction(LocalDate.of(2026, 11, 22), new BigDecimal("-12.50"), "Tesco");
    when(service.add(any(), any(), any())).thenReturn(t);

    String out = commands.add("2026-11-22", new BigDecimal("-12.50"), "Tesco");

    assertThat(out).contains("Tesco");
    verify(service).add(LocalDate.of(2026, 11, 22), new BigDecimal("-12.50"), "Tesco");
  }

  @Test
  void list_whenEmpty_saysSo() {
    when(service.listAll()).thenReturn(List.of());
    assertThat(commands.list()).isEqualTo("No transactions.");
  }
}