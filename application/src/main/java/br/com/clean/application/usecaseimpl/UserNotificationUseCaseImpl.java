package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.UserNotificationGateway;
import br.com.clean.core.domain.Transaction;
import br.com.clean.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {
    private UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
