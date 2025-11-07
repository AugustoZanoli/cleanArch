package br.com.clean.infrastructure.dto.request;

import br.com.clean.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum typeEnum, String pin) {
}
