package br.com.clean.usecase;

import br.com.clean.core.domain.Transaction;
import br.com.clean.core.exception.InternalServerErrorException;
import br.com.clean.core.exception.NotFoundException;
import br.com.clean.core.exception.NotificationException;
import br.com.clean.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException;
}
