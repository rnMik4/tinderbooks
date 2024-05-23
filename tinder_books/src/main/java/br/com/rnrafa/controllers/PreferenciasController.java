package br.com.rnrafa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rnrafa.dto.PreferenciasRequestDTO;
import br.com.rnrafa.dto.PreferenciasResponseDTO;
import br.com.rnrafa.services.PreferenciasService;

@RestController
@RequestMapping("/preferencias")
public class PreferenciasController {
	@Autowired
	private PreferenciasService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<PreferenciasResponseDTO>> listaPreferencias(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<PreferenciasResponseDTO> getPreferenciasUsuario(@PathVariable("idUsuario") Long idUsuario){
		return ResponseEntity.ok(service.getByIdUsuario(idUsuario));
	}
	
	@PostMapping
	public ResponseEntity<PreferenciasResponseDTO> novaPreferencia(@RequestBody PreferenciasRequestDTO preferencias){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(preferencias));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PreferenciasResponseDTO> atualizarPreferencia(@RequestBody PreferenciasRequestDTO preferencias, @PathVariable("id") Long id){
		return ResponseEntity.ok().body(service.update(preferencias, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarPreferencia(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.ok().body("Preferencias deletadas com sucesso");
	}
}
