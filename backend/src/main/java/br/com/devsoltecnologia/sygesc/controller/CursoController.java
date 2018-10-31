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

import br.com.devsoltecnologia.sygesc.models.Curso;
import br.com.devsoltecnologia.sygesc.services.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> find(@PathVariable Integer id) {
		Curso curso = cursoService.find(id);
		return ResponseEntity.ok().body(curso);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Curso curso) {
		curso = cursoService.insert(curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Curso curso) {
		curso.setId(id);
		curso = cursoService.update(curso);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.cursoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> curso = cursoService.findAll();
		return ResponseEntity.ok().body(curso);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Curso>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Curso> curso = cursoService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(curso);
	}

}
