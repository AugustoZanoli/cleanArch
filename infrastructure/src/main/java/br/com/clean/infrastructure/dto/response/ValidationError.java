package br.com.clean.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}
