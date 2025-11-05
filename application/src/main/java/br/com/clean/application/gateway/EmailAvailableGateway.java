package br.com.clean.application.gateway;

public interface EmailAvailableGateway {
    Boolean verify(String email);
}
