package br.com.rnrafa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rnrafa.entity.User;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.UserRepository;

@Service

public class UserServices {
	
	
	@Autowired(required = false)
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
	}
	
	public User create(User user) {
		return repository.save(user);
	}
	
	public User update(User user) {
		User entity = repository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setAddress(user.getAddress());
		entity.setGender(user.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		repository.delete(entity);
	}
}
