package br.com.thiago.listahqsbackend.repository;

import br.com.thiago.listahqsbackend.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
