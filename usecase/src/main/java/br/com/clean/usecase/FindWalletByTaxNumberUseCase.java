package br.com.clean.usecase;

import br.com.clean.core.domain.Wallet;
import br.com.clean.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findByTaxNumber(String TaxNumber) throws NotFoundException;
}