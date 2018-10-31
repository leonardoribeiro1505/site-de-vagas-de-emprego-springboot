package br.com.devsoltecnologia.sygesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.devsoltecnologia.sygesc.models.Curso;
import br.com.devsoltecnologia.sygesc.repositories.CursoRepository;
import br.com.devsoltecnologia.sygesc.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso find(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Curso.class.getName()));
	}
	
	public Curso insert(Curso curso) {
		curso.setId(null);
		return cursoRepository.save(curso);
	}
	
	public Curso update(Curso curso) {
			find(curso.getId());
			this.cursoRepository.save(curso);
		return curso;
	}
	
	public void delete(Integer id) {
		find(id);
		this.cursoRepository.deleteById(id);
	}
	
	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}
	
	public Page<Curso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cursoRepository.findAll(pageRequest);
	}

}
