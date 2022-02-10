package br.com.thiago.listahqsbackend.repository;

import br.com.thiago.listahqsbackend.entity.enuns.EditoraEnum;
import br.com.thiago.listahqsbackend.entity.Revista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevistaRepository extends MongoRepository<Revista, String> {

    List<Revista> findByNome(String nome);
    List<Revista> findByEditora(EditoraEnum editora);
}
