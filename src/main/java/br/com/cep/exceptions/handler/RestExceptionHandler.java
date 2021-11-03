package br.com.cep.exceptions.handler;

import br.com.cep.enums.ErrorCodes;
import br.com.cep.exceptions.BadRequestException;
import br.com.cep.exceptions.ExceptionResponse;
import br.com.cep.exceptions.NotFoundException;
import br.com.cep.exceptions.ViaCepClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        log.error("Bad Request Exception - ", ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        log.error("RestExceptionHandler.handleNotFoundException - NotFoundException", ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(ViaCepClientException.class)
    public final ResponseEntity<Object> handleViaCepClientException(ViaCepClientException ex) {
        log.error("RestExceptionHandler.handleViaCepClientException - ViaCep Client Exception", ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

}
