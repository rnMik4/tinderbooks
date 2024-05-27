package br.com.rnrafa.repositories;

import br.com.rnrafa.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    public List<Likes> findByIdUsuarioOwner(Long idUsuario);
    public List<Likes> findByIdUsuarioInteracao(Long idUsuario);

    public Likes findByIdUsuarioInteracaoAndIdUsuarioOwner(Long idUsuarioInteracao, Long idUsuarioOwner);
    public List<Likes> findByIdUsuarioInteracaoOrIdUsuarioOwner(Long idUsuarioInteracao, Long idUsuarioOwner);
}
