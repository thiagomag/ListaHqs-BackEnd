package br.com.thiago.listahqsbackend.controller;

import br.com.thiago.listahqsbackend.dto.UsuarioDto;
import br.com.thiago.listahqsbackend.entity.Usuario;
import br.com.thiago.listahqsbackend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok().body(usuarioService.save(usuarioDto));
    }
}
