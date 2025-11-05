package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.CreateUserGateway;
import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.domain.User;
import br.com.clean.core.domain.Wallet;
import br.com.clean.core.exception.EmailException;
import br.com.clean.core.exception.TaxNumberException;
import br.com.clean.core.exception.TransactionPinException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private EmailAvailableUseCase emailAvailableUseCase;

    private CreateWalletUseCase createWalletUseCase;

    private CreateTransactionPinUseCaseImpl createTransactionPinUseCase;

    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateWalletUseCase createWalletUseCase, CreateTransactionPinUseCaseImpl createTransactionPinUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(!emailAvailableUseCase.emailAvailable(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.E0001.getMessage(), ErrorCodeEnum.E0001.getCode());
        }

        User userCreated = createUserGateway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, userCreated));
        createTransactionPinUseCase.create(new TransactionPin(userCreated, pin));
    }
}
