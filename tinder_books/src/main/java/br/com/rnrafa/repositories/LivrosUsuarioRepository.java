package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.LivrosUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosUsuarioRepository extends JpaRepository<LivrosUsuario, Long> {

    List<LivrosUsuario> findAllByUsuario_Id(Long usuarioId);

}
