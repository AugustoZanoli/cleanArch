package br.com.clean.infrastructure.service;

import br.com.clean.application.gateway.CreateUserGateway;
import br.com.clean.core.domain.User;
import br.com.clean.core.domain.Wallet;
import br.com.clean.infrastructure.entity.TransactionPinEntity;
import br.com.clean.infrastructure.entity.UserEntity;
import br.com.clean.infrastructure.mappers.TransactionPinMapper;
import br.com.clean.infrastructure.mappers.UserMapper;
import br.com.clean.infrastructure.mappers.WallletMapper;
import br.com.clean.infrastructure.repository.TransactionPinEntityRepository;
import br.com.clean.infrastructure.repository.UserEntityRepository;
import br.com.clean.infrastructure.repository.WalletsEntityRepository;
import org.springframework.stereotype.Service;
import static br.com.clean.infrastructure.utils.Utilities.logger;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private UserEntityRepository userEntityRepository;

    private TransactionPinEntityRepository transactionPinEntityRepository;

    private WalletsEntityRepository walletsEntityRepository;


    private UserMapper userMapper;

    private TransactionPinMapper transactionPinMapper;

    private WallletMapper wallletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, TransactionPinEntityRepository transactionPinEntityRepository, UserMapper userMapper, TransactionPinMapper transactionPinMapper, WallletMapper wallletMapper, WalletsEntityRepository walletsEntityRepository) {
        this.userEntityRepository = userEntityRepository;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.wallletMapper = wallletMapper;
        this.walletsEntityRepository = walletsEntityRepository;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try{
            logger.info("Inicio metódo de criação de usuário::CreateUserGatewayImpl");

            UserEntity userCreated = userEntityRepository.save(userMapper.toUserEntity(user));
            logger.info("User salvo com sucesso::CreateUserGatewayImpl");

            TransactionPinEntity transactionPinCreated = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            logger.info("TransactionPin criado com sucesso::CreateUserGatewayImpl");

            walletsEntityRepository.save(wallletMapper.toWalletsEntity(wallet, userCreated, transactionPinCreated));
            logger.info("Wallet criada com sucesso::CreateUserGatewayImpl");

            logger.info("Fim metódo de criação de usuário::CreateUserGatewayImpl");
            return true;
        } catch (Exception e){
            logger.error("Houve um erro no método de criação do usuário::CreateUserGatewayImpl");
            return false;
        }
    }
}
