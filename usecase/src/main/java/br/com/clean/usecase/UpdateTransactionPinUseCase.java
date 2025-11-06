package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;
import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.exception.TransferException;

public interface UpdateTransactionPinUseCase {
    TransactionPin update(TransactionPin transactionPin);
}
