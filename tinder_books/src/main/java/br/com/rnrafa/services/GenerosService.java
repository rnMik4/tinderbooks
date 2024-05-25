package br.com.rnrafa.services;

import br.com.rnrafa.dto.GeneroRequestDTO;
import br.com.rnrafa.dto.GeneroResponseDTO;
import br.com.rnrafa.dto.UsuariosRequestDTO;
import br.com.rnrafa.dto.UsuariosResponseDTO;
import br.com.rnrafa.entity.Generos;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.GeneroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GenerosService {

    @Autowired
    private GeneroRepository repository;

    @Autowired
    private GenericMapper mapper;


    @GetMapping
    public List<GeneroResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), GeneroResponseDTO.class);
    }

    public GeneroResponseDTO findById(Long id) {
        Generos entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
        return mapper.entidadeParaDTO(entity, GeneroResponseDTO.class);
    }

    public GeneroResponseDTO create(GeneroRequestDTO generoDTO) {

        Generos generoSalvar = new Generos();
        BeanUtils.copyProperties(generoDTO, generoSalvar);
        generoSalvar.setDataCriacao(LocalDateTime.now());
        return mapper.entidadeParaDTO(repository.save(generoSalvar), GeneroResponseDTO.class);
    }

    public GeneroResponseDTO update(GeneroRequestDTO usuarioDTO, Long id) {
        Generos entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));

        BeanUtils.copyProperties(usuarioDTO, entity);

        entity.setId(id);

        return mapper.entidadeParaDTO(repository.save(entity), GeneroResponseDTO.class);
    }

    public void delete(Long id) {
        Generos entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        repository.delete(entity);
    }

}
