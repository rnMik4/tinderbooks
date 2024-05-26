package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.ConversasRequestDTO;
import br.com.rnrafa.dto.ConversasResponseDTO;
import br.com.rnrafa.services.ConversasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversas")
public class ConversasController {

    @Autowired
    private ConversasService service;

    @GetMapping("/list")
    public ResponseEntity<List<ConversasResponseDTO>> listarTodasConversas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list/{idUsuario1}/{idUsuario2}")
    public ResponseEntity<List<ConversasResponseDTO>> listarConversasEntre2Usuarios(@PathVariable("idUsuario1") Long idUsuario1, @PathVariable("idUsuario2") Long idUsuario2){
        return ResponseEntity.ok(service.findAllByUsuario1AndUsuario2(idUsuario1, idUsuario2));
    }

    @GetMapping("/list/{matchId}")
    public ResponseEntity<List<ConversasResponseDTO>> listarConversasPorMatch(@PathVariable("matchId") Long matchId){
        return ResponseEntity.ok(service.findAllByUsuarioMatchId(matchId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversasResponseDTO> buscarConversaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConversasResponseDTO> cadastrarConversa(@RequestBody ConversasRequestDTO conversasRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(conversasRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConversasResponseDTO> atualizarConversa(@RequestBody ConversasRequestDTO conversasRequestDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(conversasRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarConversa(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Conversa excluída com sucesso.");
    }

}
