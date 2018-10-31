package br.com.devsoltecnologia.sygesc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devsoltecnologia.sygesc.models.Cidade;
import br.com.devsoltecnologia.sygesc.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}

}
