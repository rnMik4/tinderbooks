package br.com.rnrafa.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rnrafa.dto.UsuariosRequestDTO;
import br.com.rnrafa.dto.UsuariosResponseDTO;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	private GenericMapper mapper;
	
	@Autowired(required = false)
	UsuarioRepository repository;
	
	public List<UsuariosResponseDTO> findAll(){
		return mapper.entidadeParaDTO(repository.findAll(), UsuariosResponseDTO.class);
	}
	
	public UsuariosResponseDTO findById(Long id) {
		Usuarios entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		return mapper.entidadeParaDTO(entity, UsuariosResponseDTO.class);
	}
	
	public UsuariosResponseDTO create(UsuariosRequestDTO usuarioDTO) {
		//Verifica se o e-mail ja existe na base
		Usuarios entity = repository.findByEmail(usuarioDTO.getEmail());
		if(entity != null) {
			throw new ResourceNotFoundException("Email já cadastrado");
		}
		
		Usuarios usuarioSalvar = new Usuarios();
		BeanUtils.copyProperties(usuarioDTO, usuarioSalvar);
		usuarioSalvar.setDatacriacao(LocalDateTime.now());
		return mapper.entidadeParaDTO(repository.save(usuarioSalvar), UsuariosResponseDTO.class);
	}
	
	public UsuariosResponseDTO update(UsuariosRequestDTO usuarioDTO, Long id) {
		Usuarios entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		
		BeanUtils.copyProperties(usuarioDTO, entity);
		
		entity.setId(id);
		
		return mapper.entidadeParaDTO(repository.save(entity), UsuariosResponseDTO.class);
	}
	
	public void delete(Long id) {
		Usuarios entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		repository.delete(entity);
	}
	
	public UsuariosResponseDTO login(String email, String senha) {
		Usuarios entity = repository.findByEmailAndSenha(email, senha);
		if(entity == null) {
			throw new ResourceNotFoundException("Usuário ou Senha incorretos"); 
		}
		
		return mapper.entidadeParaDTO(entity, UsuariosResponseDTO.class);
	}
	
	
}
