package br.com.cep.exceptions;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
    }

    public NotFoundException(String msg) {
        super(msg);
    }

}
