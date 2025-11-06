package br.com.clean.usecase;

import br.com.clean.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
