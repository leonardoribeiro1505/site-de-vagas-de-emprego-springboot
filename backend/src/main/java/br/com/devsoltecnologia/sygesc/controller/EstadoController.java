package br.com.devsoltecnologia.sygesc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsoltecnologia.sygesc.models.Cidade;
import br.com.devsoltecnologia.sygesc.models.Estado;
import br.com.devsoltecnologia.sygesc.services.CidadeService;
import br.com.devsoltecnologia.sygesc.services.EstadoService;

@RestController
@RequestMapping(value="/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> list = estadoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{estadoId}/cidades")
	public ResponseEntity<List<Cidade>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		return ResponseEntity.ok().body(list);
	}

}
