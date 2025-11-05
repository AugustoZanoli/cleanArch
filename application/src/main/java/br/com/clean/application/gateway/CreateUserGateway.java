package br.com.clean.application.gateway;

import br.com.clean.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
