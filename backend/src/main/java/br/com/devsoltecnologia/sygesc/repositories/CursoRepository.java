package br.com.devsoltecnologia.sygesc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devsoltecnologia.sygesc.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
}
