package br.com.rnrafa.controllers;


import br.com.rnrafa.dto.GeneroRequestDTO;
import br.com.rnrafa.dto.GeneroResponseDTO;
import br.com.rnrafa.dto.UsuariosRequestDTO;
import br.com.rnrafa.dto.UsuariosResponseDTO;
import br.com.rnrafa.services.GenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroControllers {

    @Autowired
    private GenerosService service;

    @GetMapping("/list")
    public ResponseEntity<List<GeneroResponseDTO>> listarGenero(){

        return ResponseEntity.ok().body(service.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> IdGenero(@PathVariable Long id){
        GeneroResponseDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<GeneroResponseDTO> novoUsuario(@RequestBody GeneroRequestDTO generoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(generoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> atualizarUsuario(@RequestBody GeneroRequestDTO usuarioDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(usuarioDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso");
    }
}
