package br.com.rnrafa.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rnrafa.dto.PreferenciasRequestDTO;
import br.com.rnrafa.dto.PreferenciasResponseDTO;
import br.com.rnrafa.entity.Preferencias;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.PreferenciasRepository;

@Service
public class PreferenciasService {
	@Autowired
	private GenericMapper mapper;
	
	@Autowired(required = false)
	PreferenciasRepository repository;
	
	public List<PreferenciasResponseDTO> findAll(){
		return mapper.entidadeParaDTO(repository.findAll(), PreferenciasResponseDTO.class);
	}
	
	public PreferenciasResponseDTO getByIdUsuario(Long idUsuario){
		Preferencias entity = repository.findByIdUsuario(idUsuario);
		if(entity == null) {
			throw new ResourceNotFoundException("Preferências não encontradas");
		}
		return mapper.entidadeParaDTO(entity, PreferenciasResponseDTO.class);
	}
	
	public PreferenciasResponseDTO create(PreferenciasRequestDTO preferenciasRequestDTO) {
		Preferencias entity = repository.findByIdUsuario(preferenciasRequestDTO.getIdUsuario());
		if(entity == null) {
			Preferencias preferenciasSalvar = new Preferencias();
			BeanUtils.copyProperties(preferenciasRequestDTO, preferenciasSalvar);
			preferenciasSalvar.setDatacriacao(LocalDateTime.now());
			return mapper.entidadeParaDTO(repository.save(preferenciasSalvar), PreferenciasResponseDTO.class);
		}else {
			throw new ResourceNotFoundException("Já existe Preferências cadastradas para este usuário");
		}
		
		
	}
	
	public PreferenciasResponseDTO update(PreferenciasRequestDTO preferenciasRequestDTO, Long id) {
		Preferencias entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Preferências não encontradas"));
		
		
		BeanUtils.copyProperties(preferenciasRequestDTO, entity);
		
		entity.setId(id);
		
		return mapper.entidadeParaDTO(repository.save(entity), PreferenciasResponseDTO.class);
		
	}
	
	public void delete(Long id) {
		Preferencias entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Preferências não encontradas"));
		
		repository.delete(entity);
	}
}
