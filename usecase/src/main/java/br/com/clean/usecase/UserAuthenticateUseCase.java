package br.com.clean.usecase;

import br.com.clean.core.exception.AuthenticateException;

public interface UserAuthenticateUseCase {
    Boolean authenticate(String username, String password) throws AuthenticateException;
}
