package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.TransactionValidateGateway;
import br.com.clean.core.domain.Transaction;
import br.com.clean.core.exception.TransferException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {
    private TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!transactionValidateGateway.validate(transaction)){
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
