package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.MotivosDenunciasRequestDTO;
import br.com.rnrafa.dto.MotivosDenunciasResponseDTO;
import br.com.rnrafa.services.MotivosDenunciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motivosdenuncias")
public class MotivosDenunciasController {

    @Autowired
    private MotivosDenunciasService service;

    @GetMapping("/list")
    public ResponseEntity<List<MotivosDenunciasResponseDTO>> listarMotivosDenuncias(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotivosDenunciasResponseDTO> buscarMotivoDenunciaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<MotivosDenunciasResponseDTO> cadastrarMotivoDenuncia(@RequestBody MotivosDenunciasRequestDTO motivosDenunciasRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(motivosDenunciasRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotivosDenunciasResponseDTO> atualizarMotivoDenuncia(@RequestBody MotivosDenunciasRequestDTO motivosDenunciasRequestDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(motivosDenunciasRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMotivoDenuncia(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Motivo denúncia excluído com sucesso.");
    }

}
