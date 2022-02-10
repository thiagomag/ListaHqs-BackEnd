package br.com.thiago.listahqsbackend.entity.enuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum EditoraEnum {

    MARVEL("marvel"),
    DC("dc"),
    MARVEL_PANINI("marvel panini"),
    DC_PANINI("dc panini"),
    OUTROS("outros");

    private final String id;

    public static EditoraEnum getById( String id ) {
        return Arrays.stream(values()).filter( v -> v.id.equals(id) ).findFirst().orElse( OUTROS );
    }
}
