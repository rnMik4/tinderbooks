package br.com.rnrafa.services;

import br.com.rnrafa.dto.ConversasRequestDTO;
import br.com.rnrafa.dto.ConversasResponseDTO;
import br.com.rnrafa.entity.Conversas;
import br.com.rnrafa.entity.Denuncias;
import br.com.rnrafa.exceptions.DatabaseException;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.ConversasRepository;
import br.com.rnrafa.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConversasService {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private ConversasRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ConversasResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), ConversasResponseDTO.class);
    }

    public List<ConversasResponseDTO> findAllByUsuario1AndUsuario2(final Long idUsuario1, final Long idUsuario2) {
        return mapper.entidadeParaDTO(repository.findAllByIdUsuario1AndIdUsuario2(idUsuario1, idUsuario2), ConversasResponseDTO.class);
    }

    public List<ConversasResponseDTO> findAllByUsuarioMatchId(final Long matchId) {
        return mapper.entidadeParaDTO(repository.findAllByMatchId(matchId), ConversasResponseDTO.class);
    }

    public ConversasResponseDTO findById(final Long id) {
        return mapper.entidadeParaDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há registro de conversa com id " + id + " informado.")),
                ConversasResponseDTO.class);
    }

    public ConversasResponseDTO create(final ConversasRequestDTO conversaDTO) {
        Conversas conversa = new Conversas();
        BeanUtils.copyProperties(conversaDTO, conversa);
        conversa.setDataCriacao(new Date());
        validateConversa(conversa);
        try {
            return mapper.entidadeParaDTO(repository.save(conversa), ConversasResponseDTO.class);
        } catch (final Exception ex) {
            throw new DatabaseException("Erro ao registrar conversa na base de dados. " + ex.getMessage());
        }
    }

    public ConversasResponseDTO update(final ConversasRequestDTO conversaDTO, final Long id) {
        Conversas conversa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há registro de conversa com id " + id + " informado."));
        BeanUtils.copyProperties(conversa, conversaDTO);
        validateConversa(conversa);
        try {
            return mapper.entidadeParaDTO(repository.save(conversa), ConversasResponseDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Não foi possível realizar atualização. " + e.getMessage());
        }
    }

    public void delete(final Long id) {
        Conversas conversa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há registro de conversa com id " + id + " informado."));
        try {
            repository.delete(conversa);
        } catch (final DataIntegrityViolationException ex) {
            ex.printStackTrace();
            throw new DatabaseException("Não foi possível exluir a conversa de id " + id + ". " + ex.getMessage());
        }
    }

    private void validateConversa(final Conversas conversa) {
        if (usuarioRepository.findById(conversa.getIdUsuario1()).isEmpty()) {
            throw new ResourceNotFoundException("A conversa não foi registrada, pois não há cadastro de usuário com id " + conversa.getIdUsuario1());
        }
        if (usuarioRepository.findById(conversa.getIdUsuario2()).isEmpty()) {
            throw new ResourceNotFoundException("A denúncia não foi registrada, pois não há cadastro de usuário com id " + conversa.getIdUsuario2());
        }
    }

}
