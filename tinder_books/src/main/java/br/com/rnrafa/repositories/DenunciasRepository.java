package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Denuncias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciasRepository extends JpaRepository<Denuncias, Long> {

    List<Denuncias> findAllByUsuarioDenunciadoId(Long usuarioDenunciadoId);
    List<Denuncias> findAllByUsuarioDenuncianteId(Long usuarioDenuncianteId);

}
