package br.com.querojobs.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.querojobs.models.Vaga;
import br.com.querojobs.services.VagaService;

@RestController
@RequestMapping(value="vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Vaga> find(@PathVariable String id) {
		Vaga vaga = vagaService.find(id);
		return ResponseEntity.ok().body(vaga);
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Vaga vaga) {
		vaga = vagaService.insert(vaga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Vaga vaga) {
		vaga.setId(id);
		vaga = vagaService.update(vaga);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('USUARIO')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		this.vagaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Vaga>> findAll() {
		List<Vaga> vaga = vagaService.findAll();
		return ResponseEntity.ok().body(vaga);
	}
	

}
