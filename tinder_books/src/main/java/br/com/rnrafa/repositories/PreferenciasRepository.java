package br.com.rnrafa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rnrafa.entity.Preferencias;

public interface PreferenciasRepository extends JpaRepository<Preferencias, Long>{
	public Preferencias findByIdUsuario(Long id);
}
