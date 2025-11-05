package br.com.clean.application.gateway;

import br.com.clean.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
