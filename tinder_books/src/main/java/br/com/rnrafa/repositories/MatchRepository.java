package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Matchs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Matchs, Long> {
}
