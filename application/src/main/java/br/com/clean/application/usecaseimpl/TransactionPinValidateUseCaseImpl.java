package br.com.clean.application.usecaseimpl;

import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.exception.TransferException;
import br.com.clean.usecase.TransactionPinValidateUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransferException {
        return null;
    }
}
