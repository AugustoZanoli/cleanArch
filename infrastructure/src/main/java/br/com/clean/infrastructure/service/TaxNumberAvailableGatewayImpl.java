package br.com.clean.infrastructure.service;

import br.com.clean.application.gateway.TaxNumberAvailableGateway;
import br.com.clean.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.com.clean.infrastructure.utils.Utilities.logger;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean verify(String taxNumber) {
        logger.info("Iniciando método de verificação por taxNumber");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
