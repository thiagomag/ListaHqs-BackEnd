package br.com.thiago.listahqsbackend.exception;

public class EnumNaoExisteException extends RuntimeException {
    public EnumNaoExisteException(String id) {
        super("Enum " + id + "não encontrado");
    }
}
