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
    public ResponseEntity<List<MatchResponseDTO>> listarMatchs(){
        return ResponseEntity.ok().body(service.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MatchResponseDTO> novoMatch(@RequestBody MatchRequestDTO matchDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(matchDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> atualizarMatch(@RequestBody MatchRequestDTO matchDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(matchDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMatch(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Match deletado com sucesso");
    }

    @GetMapping("/matchsusuario/{id}")
    public ResponseEntity<List<MatchResponseDTO>> listarMatchsByUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.matchsUsuario(id));
    }
}
