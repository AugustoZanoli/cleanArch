package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.CreateTransactionPinGateway;
import br.com.clean.core.domain.TransactionPin;
import br.com.clean.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway transactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway transactionPinGateway) {
        this.transactionPinGateway = transactionPinGateway;
    }


    @Override
    public void create(TransactionPin pin) {
        transactionPinGateway.create(pin);
    }
}
