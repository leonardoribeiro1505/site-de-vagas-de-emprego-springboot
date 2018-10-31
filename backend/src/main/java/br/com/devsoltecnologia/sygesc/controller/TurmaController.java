package br.com.devsoltecnologia.sygesc.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.devsoltecnologia.sygesc.models.Turma;
import br.com.devsoltecnologia.sygesc.services.TurmaService;

@RestController
@RequestMapping(value="/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> find(@PathVariable Integer id) {
		Turma turma = turmaService.find(id);
		return ResponseEntity.ok().body(turma);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Turma turma) {
		turma = turmaService.insert(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Turma turma) {
		turma.setId(id);
		turma = turmaService.update(turma);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.turmaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> turma = turmaService.findAll();
		return ResponseEntity.ok().body(turma);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Turma>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Turma> turma = turmaService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(turma);
	}

}
