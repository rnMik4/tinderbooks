package br.com.rnrafa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rnrafa.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
	public Usuarios findUsuarioById(Long id);
}
