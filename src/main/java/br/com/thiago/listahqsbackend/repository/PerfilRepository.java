package br.com.thiago.listahqsbackend.repository;

import br.com.thiago.listahqsbackend.entity.Perfil;
import br.com.thiago.listahqsbackend.entity.enuns.PerfilEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {
    Perfil findByNome(PerfilEnum nome);
}
