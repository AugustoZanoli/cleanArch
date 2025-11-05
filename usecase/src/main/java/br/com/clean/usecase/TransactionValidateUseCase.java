package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction);
}