package br.com.querojobs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.querojobs.models.Vaga;

@Repository
public interface VagaRepository extends MongoRepository<Vaga, String>{

}
