package br.com.rnrafa.services;

import br.com.rnrafa.dto.LikesRequestDTO;
import br.com.rnrafa.dto.LikesResponseDTO;
import br.com.rnrafa.dto.MatchRequestDTO;
import br.com.rnrafa.entity.Likes;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.LikesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LikesService {
    @Autowired
    private GenericMapper mapper;

    @Autowired(required = false)
    private LikesRepository repository;

    @Autowired(required = false)
    private MatchService machineService;
    @Autowired
    private MatchService matchService;

    public List<LikesResponseDTO> getByIdUsuarioInteracao(Long idUsuario){
        return mapper.entidadeParaDTO(repository.findByIdUsuarioInteracao(idUsuario), LikesResponseDTO.class);
    }

    public List<LikesResponseDTO> getByIdUsuarioOwner(Long idUsuario){
        return mapper.entidadeParaDTO(repository.findByIdUsuarioOwner(idUsuario), LikesResponseDTO.class);
    }

    public LikesResponseDTO createLike(LikesRequestDTO requestDTO){
        Likes entity = repository.findByIdUsuarioInteracaoAndIdUsuarioOwner(requestDTO.getIdUsuarioInteracao(), requestDTO.getIdUsuarioOwner());
        //Verifica se já não existe um like para essa combinação de usuario de interação e owner do livro
        if(entity != null){
            throw new ResourceNotFoundException("Like ja existente");
        }

        //cria o like
        Likes likeToSave = new Likes();
        BeanUtils.copyProperties(requestDTO, likeToSave);
        likeToSave.setDatacriacao(LocalDateTime.now());

        repository.save(likeToSave);

        //valida se existe o like inverso para gerar um match
        Likes likeInverso = repository.findByIdUsuarioInteracaoAndIdUsuarioOwner(requestDTO.getIdUsuarioOwner(), requestDTO.getIdUsuarioInteracao());
        if(likeInverso != null){
            //existe like inverso, criar match
            MatchRequestDTO matchRequestDTO = new MatchRequestDTO();
            matchRequestDTO.setIdUsuarioI(requestDTO.getIdUsuarioInteracao());
            matchRequestDTO.setIdUsuarioII(requestDTO.getIdUsuarioOwner());

            matchService.create(matchRequestDTO);

        }

        return mapper.entidadeParaDTO(likeToSave, LikesResponseDTO.class);
    }

    public List<LikesResponseDTO> getLikesByUsuario(Long idUsuario){
        return mapper.entidadeParaDTO(repository.findByIdUsuarioInteracaoOrIdUsuarioOwner(idUsuario, idUsuario), LikesResponseDTO.class);
    }
}
