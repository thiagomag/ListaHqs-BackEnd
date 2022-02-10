package br.com.thiago.listahqsbackend.entity.enuns;

import br.com.thiago.listahqsbackend.exception.EnumNaoExisteException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PerfilEnum {

    BASICO("basico"),
    ADMIN("admin");


    private final String id;

    public static PerfilEnum getById( String id ) {
        return Arrays.stream(values()).filter(v -> v.id.equals(id) ).findFirst().orElseThrow(() ->
                new EnumNaoExisteException(id));
    }
}
