package br.com.thiago.listahqsbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {

    String usuario;
    String senha;
    List<String> perfis;
}