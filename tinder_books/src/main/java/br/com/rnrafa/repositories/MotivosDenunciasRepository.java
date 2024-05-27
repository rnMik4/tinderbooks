package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.MotivosDenuncias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivosDenunciasRepository extends JpaRepository<MotivosDenuncias, Long> {

}
