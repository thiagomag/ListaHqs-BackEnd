package br.com.thiago.listahqsbackend.controller;

import br.com.thiago.listahqsbackend.dto.RevistaDto;
import br.com.thiago.listahqsbackend.entity.Revista;
import br.com.thiago.listahqsbackend.service.RevistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/revistas")
public class RevistasController {

    private final RevistaService revistaService;

    @GetMapping
    public ResponseEntity<List<Revista>> buscarTodos() {
        return ResponseEntity.ok().body(revistaService.findAll());
    }

    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<Revista>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(revistaService.findByNome(nome));
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<Revista> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(revistaService.findById(id));
    }

    @GetMapping("/buscarPorEditora/{editora}")
    public ResponseEntity<List<Revista>> buscarPorEditora(@PathVariable String editora) {
        return ResponseEntity.ok().body(revistaService.findByEditora(editora));
    }

    @PostMapping
    public ResponseEntity<Revista> salvarRevista(@RequestBody RevistaDto revistaDto, UriComponentsBuilder uriComponentsBuilder) {
        return revistaService.save(revistaDto, uriComponentsBuilder);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarRevista(@PathVariable String id) {
        return ResponseEntity.ok().body(revistaService.delete(id));
    }
}
