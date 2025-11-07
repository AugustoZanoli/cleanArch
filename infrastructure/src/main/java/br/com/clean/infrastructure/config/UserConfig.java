package br.com.clean.infrastructure.config;

import br.com.clean.application.gateway.CreateUserGateway;
import br.com.clean.application.gateway.EmailAvailableGateway;
import br.com.clean.application.gateway.TaxNumberAvailableGateway;
import br.com.clean.application.usecaseimpl.CreateUserUseCaseImpl;
import br.com.clean.application.usecaseimpl.EmailAvailableUseCaseImpl;
import br.com.clean.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import br.com.clean.usecase.CreateUserUseCase;
import br.com.clean.usecase.EmailAvailableUseCase;
import br.com.clean.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}
