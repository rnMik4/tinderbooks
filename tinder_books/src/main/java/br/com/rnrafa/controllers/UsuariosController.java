package br.com.rnrafa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuarios>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
}
