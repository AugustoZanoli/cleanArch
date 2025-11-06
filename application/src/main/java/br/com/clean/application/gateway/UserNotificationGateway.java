package br.com.clean.application.gateway;

import br.com.clean.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
