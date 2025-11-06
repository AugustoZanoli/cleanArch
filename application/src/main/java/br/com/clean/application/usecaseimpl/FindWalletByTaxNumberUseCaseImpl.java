package br.com.clean.application.usecaseimpl;

import br.com.clean.application.gateway.FindWalletByTaxNumberGateway;
import br.com.clean.core.domain.Wallet;
import br.com.clean.core.exception.NotFoundException;
import br.com.clean.core.exception.enums.ErrorCodeEnum;
import br.com.clean.usecase.FindWalletByTaxNumberUseCase;

import java.util.Objects;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws NotFoundException {
        Wallet wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if (Objects.isNull(wallet)){
            throw new NotFoundException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }
        return wallet;
    }
}
