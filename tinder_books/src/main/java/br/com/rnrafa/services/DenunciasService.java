package br.com.rnrafa.services;

import br.com.rnrafa.dto.DenunciasRequestDTO;
import br.com.rnrafa.dto.DenunciasResponseDTO;
import br.com.rnrafa.entity.Denuncias;
import br.com.rnrafa.entity.MotivosDenuncias;
import br.com.rnrafa.exceptions.DatabaseException;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.DenunciasRepository;
import br.com.rnrafa.repositories.MotivosDenunciasRepository;
import br.com.rnrafa.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DenunciasService {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private DenunciasRepository repository;

    @Autowired
    private MotivosDenunciasRepository motivosDenunciasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<DenunciasResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), DenunciasResponseDTO.class);
    }

    public List<DenunciasResponseDTO> findAllByUsuarioDenunciadoId(final Long usuarioDenunciadoId) {
        return mapper.entidadeParaDTO(repository.findAllByUsuarioDenunciadoId(usuarioDenunciadoId), DenunciasResponseDTO.class);
    }

    public List<DenunciasResponseDTO> findAllByUsuarioDenuncianteId(final Long usuarioDenuncianteId) {
        return mapper.entidadeParaDTO(repository.findAllByUsuarioDenunciadoId(usuarioDenuncianteId), DenunciasResponseDTO.class);
    }

    public DenunciasResponseDTO findById(final Long id) {
        return mapper.entidadeParaDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de denúncia com id " + id + " informado.")),
                DenunciasResponseDTO.class);
    }

    public DenunciasResponseDTO create(final DenunciasRequestDTO denunciasDTO) {
        Denuncias denuncias = new Denuncias();
        BeanUtils.copyProperties(denunciasDTO, denuncias);
        denuncias.setDataCriacao(new Date());

        MotivosDenuncias motivoDenuncia = motivosDenunciasRepository.findById(denunciasDTO.getMotivoDenunciaId())
                .orElseThrow(() -> new ResourceNotFoundException("Não é possível registrar a denúncia, pois não existe nenhum motivo denúncio cadastrado com Id " + denunciasDTO.getMotivoDenunciaId()));
        denuncias.setMotivoDenuncia(motivoDenuncia);

        validateDenuncia(denuncias);
        try {
            return mapper.entidadeParaDTO(repository.save(denuncias), DenunciasResponseDTO.class);
        } catch (final Exception ex) {
            throw new DatabaseException("Erro ao cadastrar denúncia na base de dados. " + ex.getMessage());
        }
    }

    public DenunciasResponseDTO update(final DenunciasRequestDTO denunciasDTO, final Long id) {
        Denuncias denuncias = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de denúncia com id " + id + " informado."));
        BeanUtils.copyProperties(denuncias, denunciasDTO);

        MotivosDenuncias motivoDenuncia = motivosDenunciasRepository.findById(denunciasDTO.getMotivoDenunciaId())
                .orElseThrow(() -> new ResourceNotFoundException("Não é possível atualizar a denúncia, pois não existe nenhum motivo denúncio cadastrado com Id " + denunciasDTO.getMotivoDenunciaId()));
        denuncias.setMotivoDenuncia(motivoDenuncia);

        validateDenuncia(denuncias);
        try {
            return mapper.entidadeParaDTO(repository.save(denuncias), DenunciasResponseDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Não foi possível realizar atualização. " + e.getMessage());
        }
    }

    public void delete(final Long id) {
        Denuncias denuncias = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de denúncia com id " + id + " informado."));
        try {
            repository.delete(denuncias);
        } catch (final DataIntegrityViolationException ex) {
            ex.printStackTrace();
            throw new DatabaseException("Não foi possível exluir a denúncia de id " + id + ". " + ex.getMessage());
        }
    }

    private void validateDenuncia(final Denuncias denuncia) {
        if (motivosDenunciasRepository.findById(denuncia.getMotivoDenuncia().getId()).isEmpty()) {
            throw new ResourceNotFoundException("A denúncia não foi registrada, pois não há cadastro de motivo denúncia com id: " + denuncia.getMotivoDenuncia().getId());
        }
        if (usuarioRepository.findById(denuncia.getUsuarioDenuncianteId()).isEmpty()) {
            throw new ResourceNotFoundException("A denúncia não foi registrada, pois não há cadastro de usuário com id " + denuncia.getUsuarioDenuncianteId());
        }
        if (usuarioRepository.findById(denuncia.getUsuarioDenunciadoId()).isEmpty()) {
            throw new ResourceNotFoundException("A denúncia não foi registrada, pois não há cadastro de usuário com id " + denuncia.getUsuarioDenunciadoId());
        }
    }

}
