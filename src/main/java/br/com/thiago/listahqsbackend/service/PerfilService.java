package br.com.thiago.listahqsbackend.service;

import br.com.thiago.listahqsbackend.dto.PerfilDto;
import br.com.thiago.listahqsbackend.entity.Perfil;
import br.com.thiago.listahqsbackend.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public Perfil save(PerfilDto perfilDto) {
        var perfil = Perfil.adapt(perfilDto);
        return perfilRepository.save(perfil);
    }
}