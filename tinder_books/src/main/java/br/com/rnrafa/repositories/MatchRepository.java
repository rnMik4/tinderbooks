package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Matchs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Matchs, Long> {
    public List<Matchs> findByIdUsuarioIOrIdUsuarioII(Long IdusuarioI, Long idUsuarioII);
}
