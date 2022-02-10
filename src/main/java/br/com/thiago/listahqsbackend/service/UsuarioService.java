package br.com.thiago.listahqsbackend.service;

import br.com.thiago.listahqsbackend.dto.UsuarioDto;
import br.com.thiago.listahqsbackend.entity.Perfil;
import br.com.thiago.listahqsbackend.entity.Usuario;
import br.com.thiago.listahqsbackend.entity.enuns.PerfilEnum;
import br.com.thiago.listahqsbackend.repository.PerfilRepository;
import br.com.thiago.listahqsbackend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public Usuario save(UsuarioDto usuarioDto) {
        var perfis = getListaPerfil(usuarioDto.getPerfis());
        var usuario = Usuario.adapt(usuarioDto, perfis);
        return usuarioRepository.save(usuario);
    }

    private Perfil getPerfil(PerfilEnum perfilEnum) {
        return perfilRepository.findByNome(perfilEnum);
    }

    private List<Perfil> getListaPerfil(List<String> perfis) {
        return perfis.stream().map(perfil -> getPerfil(PerfilEnum.getById(perfil))).collect(Collectors.toList());
    }
}