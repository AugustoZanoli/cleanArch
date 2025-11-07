package br.com.clean.infrastructure.mappers;

import br.com.clean.core.domain.Wallet;
import br.com.clean.infrastructure.entity.TransactionPinEntity;
import br.com.clean.infrastructure.entity.UserEntity;
import br.com.clean.infrastructure.entity.WalletsEntity;
import org.springframework.stereotype.Component;

@Component
public class WallletMapper {

    public WalletsEntity toWalletsEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletsEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}
