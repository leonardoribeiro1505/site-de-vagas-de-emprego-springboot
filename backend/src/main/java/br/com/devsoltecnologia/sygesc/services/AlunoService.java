package br.com.devsoltecnologia.sygesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.devsoltecnologia.sygesc.models.Aluno;
import br.com.devsoltecnologia.sygesc.repositories.AlunoRepository;
import br.com.devsoltecnologia.sygesc.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno find(Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
	
	public Aluno insert(Aluno aluno) {
		aluno.setId(null);
		return alunoRepository.save(aluno);
	}
	
	public Aluno update(Aluno aluno) {
			find(aluno.getId());
			this.alunoRepository.save(aluno);
		return aluno;
	}
	
	public void delete(Integer id) {
		find(id);
		this.alunoRepository.deleteById(id);
	}
	
	public List<Aluno> findAll() {
		return this.alunoRepository.findAll();
	}
	
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return alunoRepository.findAll(pageRequest);
	}

}
