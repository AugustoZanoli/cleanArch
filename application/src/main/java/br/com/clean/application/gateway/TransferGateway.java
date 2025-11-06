package br.com.clean.application.gateway;

import br.com.clean.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
