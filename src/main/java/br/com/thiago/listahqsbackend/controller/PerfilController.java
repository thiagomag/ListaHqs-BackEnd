package br.com.thiago.listahqsbackend.controller;

import br.com.thiago.listahqsbackend.entity.Perfil;
import br.com.thiago.listahqsbackend.dto.PerfilDto;
import br.com.thiago.listahqsbackend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    public ResponseEntity<Perfil> salvarPerfil(@RequestBody PerfilDto perfilDto) {
        return ResponseEntity.ok().body(perfilService.save(perfilDto));
    }
}
