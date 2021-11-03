package br.com.cep.exceptions;

public class ViaCepClientException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ViaCepClientException(String msg) {
        super(msg);
    }
}