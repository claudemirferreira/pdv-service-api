package br.com.claudemir.pdvserviceapi.service.exceptions;

public class ExisteCaixaAbertoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExisteCaixaAbertoException(String msg){
        super(msg);
    }

    public ExisteCaixaAbertoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
