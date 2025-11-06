package br.com.clean.application.gateway;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
