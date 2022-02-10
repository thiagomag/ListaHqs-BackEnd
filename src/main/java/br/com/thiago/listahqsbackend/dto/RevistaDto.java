package br.com.thiago.listahqsbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RevistaDto {

    String nome;
    String volume;
    String autor;
    String idioma;
    String editora;
    String linkMercadoLivre;
    String linkShopee;
    List<String> linkFotos;
}
