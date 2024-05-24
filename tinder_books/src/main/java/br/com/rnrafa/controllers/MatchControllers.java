package br.com.rnrafa.controllers;


import br.com.rnrafa.dto.MatchRequestDTO;
import br.com.rnrafa.dto.MatchResponseDTO;
import br.com.rnrafa.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchs")
public class MatchControllers {

    @Autowired
    private MatchService service;

    @GetMapping("/list")
    public ResponseEntity<List<MatchResponseDTO>> listarGenero(){
        List list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> IdGenero(@PathVariable Long id){
        MatchResponseDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MatchResponseDTO> novoUsuario(@RequestBody MatchResponseDTO matchDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(matchDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> atualizarUsuario(@RequestBody MatchRequestDTO matchDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(matchDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso");
    }
}
