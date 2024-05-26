package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.LivrosUsuarioRequestDTO;
import br.com.rnrafa.dto.LivrosUsuarioResponseDTO;
import br.com.rnrafa.services.LivrosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosUsuarioController {

    @Autowired
    private LivrosUsuarioService service;

    @GetMapping("/list")
    public ResponseEntity<List<LivrosUsuarioResponseDTO>> listarTodosLivros() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list/{usuarioId}")
    public ResponseEntity<List<LivrosUsuarioResponseDTO>> listarLivrosPorUsuario(@PathVariable("usuarioId") final Long usuarioId) {
        return ResponseEntity.ok(service.findAllByUsuarioId(usuarioId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivrosUsuarioResponseDTO> obterLivroPorId(@PathVariable("id") final Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LivrosUsuarioResponseDTO> cadastrarLivro(@RequestBody final LivrosUsuarioRequestDTO livroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(livroDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivrosUsuarioResponseDTO> atualizarCadastroLivro(@RequestBody final LivrosUsuarioRequestDTO livroDTO, @PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(service.update(livroDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Livro deletado com sucesso");
    }

}
