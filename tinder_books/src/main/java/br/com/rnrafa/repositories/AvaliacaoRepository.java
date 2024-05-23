package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Avaliacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacoes, Long> {

    List<Avaliacoes> findAllByUsuario_Id(final Long usuarioId);

}
