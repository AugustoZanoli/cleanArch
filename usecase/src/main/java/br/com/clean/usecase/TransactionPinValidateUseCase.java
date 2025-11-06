package br.com.clean.usecase;

import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.exception.TransferException;

public interface TransactionPinValidateUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException;
}