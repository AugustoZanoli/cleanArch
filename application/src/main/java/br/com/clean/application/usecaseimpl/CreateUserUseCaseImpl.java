package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.CreateUserGateway;
import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.domain.User;
import br.com.clean.core.domain.Wallet;
import br.com.clean.core.exception.EmailException;
import br.com.clean.core.exception.InternalServerErrorException;
import br.com.clean.core.exception.TaxNumberException;
import br.com.clean.core.exception.TransactionPinException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private EmailAvailableUseCase emailAvailableUseCase;

    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException, InternalServerErrorException {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())){
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        if(!emailAvailableUseCase.emailAvailable(user.getEmail())){
            throw new EmailException(ErrorCodeEnum.E0001.getMessage(), ErrorCodeEnum.E0001.getCode());
        }


        if(!createUserGateway.create(user, new Wallet(new TransactionPin(pin), BigDecimal.ZERO, user))) {
            throw new InternalServerErrorException(ErrorCodeEnum.US0001.getMessage(), ErrorCodeEnum.US0001.getCode());
        }
    }
}
