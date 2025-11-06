package br.com.clean.application.gateway;

import br.com.clean.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
