package br.com.clean.application.gateway;

import br.com.clean.core.domain.TransactionPin;
import br.com.clean.core.domain.User;
import br.com.clean.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet, TransactionPin transactionPin);
}
