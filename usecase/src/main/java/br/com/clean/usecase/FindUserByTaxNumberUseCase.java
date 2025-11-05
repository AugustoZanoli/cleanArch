package br.com.clean.usecase;

import br.com.clean.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findByTaxNumber(String TaxNumber);
}