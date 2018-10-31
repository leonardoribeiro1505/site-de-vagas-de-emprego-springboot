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

import br.com.devsoltecnologia.sygesc.models.Responsavel;
import br.com.devsoltecnologia.sygesc.services.ResponsavelService;

@RestController
@RequestMapping(value="/responsaveis")
public class ResponsavelController {
	
	@Autowired //Apenas um teste de comentário
	private ResponsavelService responsavelService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Responsavel> find(@PathVariable Integer id) {
		Responsavel responsavel = responsavelService.find(id);
		return ResponseEntity.ok().body(responsavel);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Responsavel responsavel) {
		responsavel = responsavelService.insert(responsavel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(responsavel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Responsavel responsavel) {
		responsavel.setId(id);
		responsavel = responsavelService.update(responsavel);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.responsavelService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<Responsavel>> findAll() {
		List<Responsavel> responsavel = responsavelService.findAll();
		return ResponseEntity.ok().body(responsavel);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Responsavel>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Responsavel> responsavel = responsavelService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(responsavel);
	}

}
