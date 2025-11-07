package br.com.clean.infrastructure.controller;

import br.com.clean.infrastructure.dto.request.CreateUserRequest;
import br.com.clean.infrastructure.dto.response.BaseResponse;
import br.com.clean.infrastructure.mappers.UserMapper;
import br.com.clean.usecase.CreateUserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.com.clean.infrastructure.utils.Utilities.logger;


@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private CreateUserUseCase createUserUseCase;

    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/create-user")
    public BaseResponse<String> createUser(
            @RequestBody CreateUserRequest request
    ) throws Exception {
        logger.info("Iniciando criação de usuário::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        logger.info("Usuário criado com sucesso::UserController");
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso!").build();
    }
}
