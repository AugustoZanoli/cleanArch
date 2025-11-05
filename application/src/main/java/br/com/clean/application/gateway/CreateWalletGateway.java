package br.com.clean.application.gateway;

import br.com.clean.core.domain.User;
import br.com.clean.core.domain.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);

}
