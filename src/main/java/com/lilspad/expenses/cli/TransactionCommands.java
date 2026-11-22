package com.lilspad.expenses.cli;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

import com.lilspad.expenses.model.Transaction;
import com.lilspad.expenses.service.TransactionService;

@Component 
public class TransactionCommands {
  private final TransactionService transactions;

  public TransactionCommands(TransactionService transactions) {
    this.transactions = transactions;
  }

  @Command(name = "add", description = "Add a transaction")
  public String add(
    @Option String date,
    @Option BigDecimal amount,
    @Option String description) {
      Transaction t = transactions.add(LocalDate.parse(date), amount, description);
      return "Added " + t;
    }

  @Command(name = "list", description = "List transactions")
  public String list() {
    List<Transaction> all = transactions.listAll();
    if (all.isEmpty()) {
      return "No transactions.";
    }

    StringBuilder sb = new StringBuilder();
    for (Transaction t : all) {
      sb.append(t).append("\n");
    }
    return sb.toString().strip();
  }
}
