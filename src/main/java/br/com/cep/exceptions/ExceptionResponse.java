package br.com.cep.exceptions;

import br.com.cep.enums.ErrorCodes;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Getter
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;
    private final List<String> details;

    public ExceptionResponse(final ErrorCodes errorCode, String details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = Collections.singletonList(details);
    }

    public ExceptionResponse(ErrorCodes errorCode, List<String> details) {
        this.code = errorCode.name();
        this.message = errorCode.getMessage();
        this.details = details;
    }

}
