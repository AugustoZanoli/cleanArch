package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
