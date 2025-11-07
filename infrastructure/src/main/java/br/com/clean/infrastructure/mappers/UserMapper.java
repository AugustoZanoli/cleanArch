package br.com.clean.infrastructure.mappers;

import br.com.clean.core.domain.TaxNumber;
import br.com.clean.core.domain.User;
import br.com.clean.infrastructure.dto.request.CreateUserRequest;
import br.com.clean.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(User user) {
        return  new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullname(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
            request.email(),
            request.password(),
            new TaxNumber(request.taxNumber()),
            request.fullname(),
            request.typeEnum()
        );
    }
}
