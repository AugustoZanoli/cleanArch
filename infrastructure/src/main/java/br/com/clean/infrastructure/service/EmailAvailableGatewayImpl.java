package br.com.clean.infrastructure.service;

import br.com.clean.application.gateway.EmailAvailableGateway;
import br.com.clean.infrastructure.repository.UserEntityRepository;

public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean verify(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}
