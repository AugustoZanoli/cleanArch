package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;
import br.com.clean.core.exception.TransferException;

public interface TransactionValidateUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}