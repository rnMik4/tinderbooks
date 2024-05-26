package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.AvaliacoesRequestDTO;
import br.com.rnrafa.dto.AvaliacoesResponseDTO;
import br.com.rnrafa.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacoesController {

    @Autowired
    private AvaliacaoService service;

    @GetMapping("list")
    public ResponseEntity<List<AvaliacoesResponseDTO>> listarTodasAvaliacoes() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list/{usuarioId}")
    public ResponseEntity<List<AvaliacoesResponseDTO>> listarTodasAvaliacoesPorUsuario(@PathVariable("usuarioId") final Long usuarioId) {
        return ResponseEntity.ok(service.findAllByUsuarioId(usuarioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacoesResponseDTO> obterAvaliacaoPorId(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AvaliacoesResponseDTO> cadastrarAvaliacao(@RequestBody final AvaliacoesRequestDTO avaliacoesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(avaliacoesDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacoesResponseDTO> atualizarAvaliacao(@RequestBody final AvaliacoesRequestDTO avaliacoesDTO, @PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(service.update(avaliacoesDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAvaliacao(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Avaliação deletada com sucesso");
    }

}
