package br.com.rnrafa.controllers;

import br.com.rnrafa.dto.DenunciasRequestDTO;
import br.com.rnrafa.dto.DenunciasResponseDTO;
import br.com.rnrafa.services.DenunciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciasController {

    @Autowired
    private DenunciasService service;

    @GetMapping("/list")
    public ResponseEntity<List<DenunciasResponseDTO>> listarTodasDenuncias(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/list/userdenunciante/{idUsuarioDenunciante}")
    public ResponseEntity<List<DenunciasResponseDTO>> listarDenunciasPorUsuarioDenunciate(@PathVariable("idUsuarioDenunciante") Long usuarioDenuncianteId){
        return ResponseEntity.ok(service.findAllByUsuarioDenuncianteId(usuarioDenuncianteId));
    }

    @GetMapping("/list/userdenunciado/{idUsuarioDenunciado}")
    public ResponseEntity<List<DenunciasResponseDTO>> listarDenunciasPorUsuarioDenunciado(@PathVariable("idUsuarioDenunciado") Long usuarioDenunciadoId){
        return ResponseEntity.ok(service.findAllByUsuarioDenunciadoId(usuarioDenunciadoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciasResponseDTO> buscarDenunciaPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DenunciasResponseDTO> cadastrarDenuncia(@RequestBody DenunciasRequestDTO denunciasRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(denunciasRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DenunciasResponseDTO> atualizarDenuncia(@RequestBody DenunciasRequestDTO denunciasRequestDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.update(denunciasRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDenuncia(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().body("Denúncia excluída com sucesso.");
    }

}
