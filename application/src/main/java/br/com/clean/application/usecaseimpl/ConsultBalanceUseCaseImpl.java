package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.ConsultBalanceGateway;
import br.com.clean.core.domain.Wallet;
import br.com.clean.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {
    private ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return consultBalanceGateway.consult(wallet);
    }
}
