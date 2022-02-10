package br.com.thiago.listahqsbackend.entity;

import br.com.thiago.listahqsbackend.dto.PerfilDto;
import br.com.thiago.listahqsbackend.entity.enuns.PerfilEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
@Document
public class Perfil implements GrantedAuthority {

    @Id
    private String id;
    private PerfilEnum nome;

    public static Perfil adapt(PerfilDto perfilDto) {
        var perfilEnum = PerfilEnum.getById(perfilDto.getNome());
        return Perfil.builder()
                .nome(perfilEnum)
                .build();
    }

    @Override
    public String getAuthority() {
        return nome.getId();
    }
}
