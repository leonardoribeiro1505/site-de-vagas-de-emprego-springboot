package br.com.querojobs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.querojobs.models.auth.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);

}
