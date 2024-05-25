package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Generos, Long> {
}
