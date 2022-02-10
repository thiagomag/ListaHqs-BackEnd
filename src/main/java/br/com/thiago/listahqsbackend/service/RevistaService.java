package br.com.thiago.listahqsbackend.service;

import br.com.thiago.listahqsbackend.dto.RevistaDto;
import br.com.thiago.listahqsbackend.entity.enuns.EditoraEnum;
import br.com.thiago.listahqsbackend.entity.Revista;
import br.com.thiago.listahqsbackend.exception.RevistaNotFoundException;
import br.com.thiago.listahqsbackend.repository.RevistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RevistaService {

    private final RevistaRepository revistaRepository;

    public List<Revista> findAll() {
        return revistaRepository.findAll();
    }

    public ResponseEntity<Revista> save(RevistaDto revistaDto, UriComponentsBuilder uriComponentsBuilder) {
        var revista = Revista.adapt(revistaDto);
        revistaRepository.save(revista);
        var uri = uriComponentsBuilder.path("/revistas/buscarRevista/{id}").buildAndExpand(revista.getId()).toUri();
        return ResponseEntity.created(uri).body(revista);
    }

    public ResponseEntity<?> delete(String id) {
        var revista = revistaRepository.findById(id).orElseThrow(() -> new RevistaNotFoundException(id));
        revista.setDeletedTmsp(LocalDateTime.now());
        return ResponseEntity.ok().build();
    }

    public List<Revista> findByNome(String nome) {
        return revistaRepository.findByNome(nome);
    }

    public Revista findById(String id) {
        return revistaRepository.findById(id).orElseThrow(() -> new RevistaNotFoundException(id));
    }

    public List<Revista> findByEditora(String editora) {
        var editoraEnum = EditoraEnum.getById(editora);
        return revistaRepository.findByEditora(editoraEnum);
    }
}