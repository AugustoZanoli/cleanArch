package br.com.clean.application.gateway;

import br.com.clean.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
