package br.com.clean.usecase;

import br.com.clean.core.domain.User;
import br.com.clean.core.exception.EmailException;
import br.com.clean.core.exception.TaxNumberException;
import br.com.clean.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException;
}
