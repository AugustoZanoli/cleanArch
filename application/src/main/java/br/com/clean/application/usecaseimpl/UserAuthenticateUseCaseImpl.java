package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.UserAuthenticateGateway;
import br.com.clean.core.exception.AuthenticateException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.UserAuthenticateUseCase;

import javax.naming.AuthenticationException;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if(!userAuthenticateGateway.authenticate(username, password)){
            throw new AuthenticateException(ErrorCodeEnum.AT0001.getMessage(), ErrorCodeEnum.AT0001.getCode());
        }
        return true;
    }
}
