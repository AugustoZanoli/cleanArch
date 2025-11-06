package br.com.clean.application.gateway;

import br.com.clean.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
