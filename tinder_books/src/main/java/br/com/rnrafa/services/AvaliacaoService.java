package br.com.rnrafa.services;

import br.com.rnrafa.dto.AvaliacoesRequestDTO;
import br.com.rnrafa.dto.AvaliacoesResponseDTO;
import br.com.rnrafa.entity.Avaliacoes;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.DatabaseException;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.AvaliacaoRepository;
import br.com.rnrafa.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<AvaliacoesResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), AvaliacoesResponseDTO.class);
    }

    public List<AvaliacoesResponseDTO> findAllByUsuarioId(final Long usuarioId) {
        return mapper.entidadeParaDTO(repository.findAllByUsuario_Id(usuarioId), AvaliacoesResponseDTO.class);
    }

    public AvaliacoesResponseDTO findById(final Long id) {
        return mapper.entidadeParaDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada")),
                AvaliacoesResponseDTO.class);
    }

    public AvaliacoesResponseDTO create(final AvaliacoesRequestDTO avaliacaoDTO, final Long usuarioId, final Long matchId) {
        Avaliacoes avaliacaoEntidade = new Avaliacoes();
        BeanUtils.copyProperties(avaliacaoDTO, avaliacaoEntidade);
        avaliacaoEntidade.setDataCriacao(new Date());
        Usuarios usuario = usuarioRepository.findById(usuarioId).
                orElseThrow(() -> new ResourceNotFoundException("Não foi possível cadastrar a avaliação pois não existe cadastro do usuário de id " + usuarioId));
        avaliacaoEntidade.setUsuario(usuario);

        // TODO:  Quando as entidades Like e Match estiverem prontas, trocar o atriburo matchId pelo objeto da entidade na classe.
        avaliacaoEntidade.setMatchId(matchId);
        return mapper.entidadeParaDTO(repository.save(avaliacaoEntidade), AvaliacoesResponseDTO.class);
    }

    public AvaliacoesResponseDTO update(final AvaliacoesRequestDTO avaliacaoDTO, final Long id) {
        Avaliacoes entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada"));
        BeanUtils.copyProperties(avaliacaoDTO, entity);
        entity.setId(id);

        try {
            return mapper.entidadeParaDTO(repository.save(entity), AvaliacoesResponseDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Não foi possível atualizar dados da avaliação do usuário. " + e.getMessage());
        }
    }

    public void delete(final Long id) {
        Avaliacoes entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada!"));
        try {
            repository.delete(entity);
        } catch (DataIntegrityViolationException ex) {
            ex.printStackTrace();
            throw new DatabaseException("Não foi possível excluir a avaliação do usuário. " + ex.getMessage());
        }
    }

}
