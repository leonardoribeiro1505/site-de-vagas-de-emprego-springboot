package br.com.devsoltecnologia.sygesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.devsoltecnologia.sygesc.models.Turma;
import br.com.devsoltecnologia.sygesc.repositories.TurmaRepository;
import br.com.devsoltecnologia.sygesc.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public Turma find(Integer id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
	}
	
	public Turma insert(Turma turma) {
		turma.setId(null);
		return turmaRepository.save(turma);
	}
	
	public Turma update(Turma turma) {
			find(turma.getId());
			this.turmaRepository.save(turma);
		return turma;
	}
	
	public void delete(Integer id) {
		find(id);
		this.turmaRepository.deleteById(id);
	}
	
	public List<Turma> findAll() {
		return this.turmaRepository.findAll();
	}
	
	public Page<Turma> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return turmaRepository.findAll(pageRequest);
	}

}
