package br.com.rnrafa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.ResourceNotFoundException;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	public Usuarios findUsuarioById(Long id);
	public Usuarios findByEmail(String email);
	
	public Usuarios findByEmailAndSenha(String email, String senha);
}
