package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Conversas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversasRepository extends JpaRepository<Conversas, Long> {

    List<Conversas> findAllByIdUsuario1AndIdUsuario2(Long idUsuario1, Long idUsuario2);
    List<Conversas> findAllByMatchId(Long matchId);

}
