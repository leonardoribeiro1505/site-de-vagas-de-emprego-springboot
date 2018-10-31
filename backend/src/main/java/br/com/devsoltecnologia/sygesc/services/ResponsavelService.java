package br.com.devsoltecnologia.sygesc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.devsoltecnologia.sygesc.models.Responsavel;
import br.com.devsoltecnologia.sygesc.repositories.ResponsavelRepository;
import br.com.devsoltecnologia.sygesc.services.exceptions.ObjectNotFoundException;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	public Responsavel find(Integer id) {
		Optional<Responsavel> responsavel = responsavelRepository.findById(id);
		return responsavel.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Responsavel.class.getName()));
	}
	
	public Responsavel insert(Responsavel responsavel) {
		responsavel.setId(null);
		return responsavelRepository.save(responsavel);
	}
	
	public Responsavel update(Responsavel responsavel) {
			find(responsavel.getId());
			this.responsavelRepository.save(responsavel);
		return responsavel;
	}
	
	public void delete(Integer id) {
		find(id);
		this.responsavelRepository.deleteById(id);
	}
	
	public List<Responsavel> findAll() {
		return this.responsavelRepository.findAll();
	}
	
	public Page<Responsavel> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return responsavelRepository.findAll(pageRequest);
	}

}
