package br.com.rnrafa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rnrafa.dto.UsuariosRequestDTO;
import br.com.rnrafa.dto.UsuariosResponseDTO;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private UsuariosService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<UsuariosResponseDTO>> listarUsuario(){
		return ResponseEntity.ok(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuariosResponseDTO> buscarUsuarioId(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<UsuariosResponseDTO> novoUsuario(@RequestBody UsuariosRequestDTO usuarioDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(usuarioDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuariosResponseDTO> atualizarUsuario(@RequestBody UsuariosRequestDTO usuarioDTO, @PathVariable("id") Long id) {
		return ResponseEntity.ok().body(service.update(usuarioDTO, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().body("Usuario deletado com sucesso");
	}
	
	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<UsuariosResponseDTO> login(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		return ResponseEntity.ok().body(service.login(email, senha));
	}
}
