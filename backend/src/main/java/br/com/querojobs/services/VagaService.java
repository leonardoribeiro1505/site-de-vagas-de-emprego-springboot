package br.com.querojobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.querojobs.models.Vaga;
import br.com.querojobs.repositories.VagaRepository;
import br.com.querojobs.security.JwtUserFactory;
import br.com.querojobs.security.UserSS;
import br.com.querojobs.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public Vaga find(String id) {
		Optional<Vaga> vaga = vagaRepository.findById(id);
		return vaga.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}
	
	public Vaga insert(Vaga vaga) {
		vaga.setId(null);
		UserSS usuario = JwtUserFactory.create(SecurityContextHolder.getContext().getAuthentication());
		vaga.setCreatedBy(usuario.getId());
		return vagaRepository.save(vaga);
	}
	
	public Vaga update(Vaga vaga) {
			find(vaga.getId());
			this.vagaRepository.save(vaga);
		return vaga;
	}
	
	public void delete(String id) {
		find(id);
		this.vagaRepository.deleteById(id);
	}
	
	public List<Vaga> findAll() {
		return this.vagaRepository.findAll();
	}

}
