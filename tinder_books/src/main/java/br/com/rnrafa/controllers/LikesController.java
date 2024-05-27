package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.LikesRequestDTO;
import br.com.rnrafa.dto.LikesResponseDTO;
import br.com.rnrafa.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private LikesService service;

    @PostMapping
    public ResponseEntity<LikesResponseDTO> createLike(@RequestBody LikesRequestDTO likesRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createLike(likesRequestDTO));
    }

    @GetMapping("/likesUsuario/{id}")
    public ResponseEntity<List<LikesResponseDTO>> getLike(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLikesByUsuario(id));
    }
}
