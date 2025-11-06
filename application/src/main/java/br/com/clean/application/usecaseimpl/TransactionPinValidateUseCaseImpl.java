package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.TransactionPinValidateGateway;
import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.exception.PinException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.TransactionPinValidateUseCase;
import br.com.clean.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {
    private TransactionPinValidateGateway transactionPinValidateGateway;

    private UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public TransactionPinValidateUseCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if(transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }
        if(!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            TransactionPin transactionPinUpdated = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(transactionPinUpdated.getAttempt()), ErrorCodeEnum.WA0001.getCode());
        }

        if(transactionPin.getAttempt() < 3) {
            transactionPin.restoreAttempt();
            updateTransactionPinUseCase.update(transactionPin);
        }
        return true;
    }
}
