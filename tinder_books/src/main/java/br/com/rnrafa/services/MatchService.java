package br.com.rnrafa.services;


import br.com.rnrafa.dto.MatchRequestDTO;
import br.com.rnrafa.dto.MatchResponseDTO;
import br.com.rnrafa.entity.Matchs;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.MatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository repository;

    @Autowired
    private GenericMapper mapper;


    @GetMapping
    public List<MatchResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), MatchResponseDTO.class);
    }

    public MatchResponseDTO findById(Long id) {
        Matchs entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match não encontrado"));
        return mapper.entidadeParaDTO(entity, MatchResponseDTO.class);
    }

    public MatchResponseDTO create(MatchRequestDTO matchDto) {

        Matchs matchSalvar = new Matchs();
        BeanUtils.copyProperties(matchDto, matchSalvar);
        matchSalvar.setDataCriacao(LocalDateTime.now());
        return mapper.entidadeParaDTO(repository.save(matchSalvar), MatchResponseDTO.class);
    }

    public MatchResponseDTO update(MatchRequestDTO matchDto, Long id) {
        Matchs entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match não encontrado"));

        BeanUtils.copyProperties(matchDto, entity);

        entity.setId(id);

        return mapper.entidadeParaDTO(repository.save(entity), MatchResponseDTO.class);
    }

    public void delete(Long id) {
        Matchs entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match não encontrado!"));
        repository.delete(entity);
    }

    public List<MatchResponseDTO> matchsUsuario(Long id){
        return mapper.entidadeParaDTO(repository.findByIdUsuarioIOrIdUsuarioII(id, id), MatchResponseDTO.class);
    }

}
