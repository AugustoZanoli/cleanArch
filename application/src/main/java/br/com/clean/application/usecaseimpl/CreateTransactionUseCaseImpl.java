package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.CreateTransactionGateway;
import br.com.clean.core.domain.Transaction;
import br.com.clean.core.exception.TransferException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.CreateTransactionUseCase;

import java.util.Objects;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        Transaction transactionCreated = createTransactionGateway.create(transaction);

        if (Objects.isNull(transactionCreated)) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        return transactionCreated;
    }
}
