package br.com.rnrafa.services;

import br.com.rnrafa.dto.LivrosUsuarioRequestDTO;
import br.com.rnrafa.dto.LivrosUsuarioResponseDTO;
import br.com.rnrafa.dto.MotivosDenunciasRequestDTO;
import br.com.rnrafa.dto.MotivosDenunciasResponseDTO;
import br.com.rnrafa.entity.LivrosUsuario;
import br.com.rnrafa.entity.MotivosDenuncias;
import br.com.rnrafa.exceptions.DatabaseException;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.MotivosDenunciasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MotivosDenunciasService {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private MotivosDenunciasRepository repository;

    public List<MotivosDenunciasResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), MotivosDenunciasResponseDTO.class);
    }

    public MotivosDenunciasResponseDTO findById(Long id) {
        return mapper.entidadeParaDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de motivo denúncia com id " + id + " informado.")),
                MotivosDenunciasResponseDTO.class);
    }

    public MotivosDenunciasResponseDTO create(final MotivosDenunciasRequestDTO motivoDenunciaDTO) {
        MotivosDenuncias motivosDenuncias = new MotivosDenuncias();
        BeanUtils.copyProperties(motivoDenunciaDTO, motivosDenuncias);
        motivosDenuncias.setDataCriacao(new Date());
        try {
            return mapper.entidadeParaDTO(repository.save(motivosDenuncias), MotivosDenunciasResponseDTO.class);
        } catch (Exception e) {
            throw new DatabaseException("Erro ao cadastrar motivo denúncia na base de dados. " + e.getMessage());
        }
    }

    public MotivosDenunciasResponseDTO update(final MotivosDenunciasRequestDTO motivoDenunciaDTO, final Long id) {
        MotivosDenuncias motivoDenuncia = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de motivo denúncia com id " + id + " informado."));
        BeanUtils.copyProperties(motivoDenuncia, motivoDenunciaDTO);
        try {
            return mapper.entidadeParaDTO(repository.save(motivoDenuncia), MotivosDenunciasResponseDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Não foi possível realizar atualização. " + e.getMessage());
        }
    }

    public void delete(final Long id) {
        MotivosDenuncias motivoDenuncia = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de motivo denúncia com id " + id + " informado."));
        try {
            repository.delete(motivoDenuncia);
        } catch (final DataIntegrityViolationException ex) {
            ex.printStackTrace();
            throw new DatabaseException("Não foi possível exluir o motivo denúncia de id " + id + ". " + ex.getMessage());
        }
    }

}
