package br.com.thiago.listahqsbackend.entity;

import br.com.thiago.listahqsbackend.dto.UsuarioDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@Document
public class Usuario implements UserDetails {

    @Id
    String usuario;
    String senha;
    List<Perfil> perfis;

    public static Usuario adapt(UsuarioDto usuarioDto, List<Perfil> perfis) {
        return Usuario.builder()
                .usuario(usuarioDto.getUsuario())
                .senha(usuarioDto.getSenha())
                .perfis(perfis)
                .build();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}