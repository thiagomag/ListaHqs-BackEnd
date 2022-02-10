package br.com.thiago.listahqsbackend.exception;

public class RevistaNotFoundException extends RuntimeException {

    public RevistaNotFoundException(String id) {
        super("Id " + id + "não encontrado");
    }
}
