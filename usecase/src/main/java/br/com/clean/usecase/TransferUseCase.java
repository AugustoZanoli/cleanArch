package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;
import br.com.clean.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException;
}
