package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
