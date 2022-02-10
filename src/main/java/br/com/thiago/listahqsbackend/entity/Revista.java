package br.com.thiago.listahqsbackend.entity;

import br.com.thiago.listahqsbackend.dto.RevistaDto;
import br.com.thiago.listahqsbackend.entity.enuns.EditoraEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Document
public class Revista {

    @Id
    String id;
    String nome;
    String volume;
    String autor;
    String idioma;
    EditoraEnum editora;
    String linkMercadoLivre;
    String linkShopee;
    List<String> linkFotos;
    LocalDateTime deletedTmsp;

    public static Revista adapt(RevistaDto revistaDto) {
        var editoraEnum = EditoraEnum.getById(revistaDto.getEditora());
        return Revista.builder()
                .nome(revistaDto.getNome())
                .volume(revistaDto.getVolume())
                .autor(revistaDto.getAutor())
                .idioma(revistaDto.getIdioma())
                .editora(editoraEnum)
                .linkMercadoLivre(revistaDto.getLinkMercadoLivre())
                .linkShopee(revistaDto.getLinkShopee())
                .linkFotos(revistaDto.getLinkFotos())
                .build();
    }
}