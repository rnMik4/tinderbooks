package br.com.rnrafa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.UsuarioRepository;

@Service
public class UsuariosService {
	@Autowired(required = false)
	UsuarioRepository repository;
	
	public List<Usuarios> findAll(){
		return repository.findAll();
	}
	
	public Usuarios findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
	}
	
	public Usuarios create(Usuarios usuario) {
		return repository.save(usuario);
	}
	
	public Usuarios update(Usuarios usuario) {
		Usuarios entity = repository.findById(usuario.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		
		entity.setNomeCompleto(usuario.getNomeCompleto());
		entity.setEmail(usuario.getEmail());
		entity.setCep(usuario.getCep());
		entity.setRua(usuario.getRua());
		entity.setCidade(usuario.getCidade());
		entity.setUf(usuario.getUf());
		entity.setLatitude(usuario.getLatitude());
		entity.setLongitude(usuario.getLongitude());
		entity.setDdd(usuario.getDdd());
		entity.setTelefone(usuario.getTelefone());
		entity.setAtivo(usuario.getAtivo());
		entity.setAceiteTermos(usuario.getAceiteTermos());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Usuarios entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		repository.delete(entity);
	}
}
