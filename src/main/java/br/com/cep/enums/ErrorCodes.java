package br.com.cep.enums;

public enum ErrorCodes {

    INTERNAL_SERVER_ERROR("Internal server error"),
    NOT_FOUND("Not found"),
    BAD_REQUEST("Bad request");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
