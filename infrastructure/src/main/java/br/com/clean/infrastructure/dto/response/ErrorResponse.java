package br.com.clean.infrastructure.dto.response;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import java.util.List;

public record ErrorResponse(String code, String message, List<ValidationError> errorsList) {
}
