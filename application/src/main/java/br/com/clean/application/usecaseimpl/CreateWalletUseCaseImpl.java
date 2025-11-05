package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.CreateWalletGateway;
import br.com.clean.core.domain.Wallet;
import br.com.clean.usecase.CreateWalletUseCase;

import java.util.Objects;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
