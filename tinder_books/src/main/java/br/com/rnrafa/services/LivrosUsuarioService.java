package br.com.rnrafa.services;

import br.com.rnrafa.dto.LivrosUsuarioRequestDTO;
import br.com.rnrafa.dto.LivrosUsuarioResponseDTO;
import br.com.rnrafa.entity.LivrosUsuario;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.exceptions.DatabaseException;
import br.com.rnrafa.exceptions.ResourceNotFoundException;
import br.com.rnrafa.repositories.LivrosUsuarioRepository;
import br.com.rnrafa.repositories.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LivrosUsuarioService {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private LivrosUsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<LivrosUsuarioResponseDTO> findAll() {
        return mapper.entidadeParaDTO(repository.findAll(), LivrosUsuarioResponseDTO.class);
    }

    public List<LivrosUsuarioResponseDTO> findAllByUsuarioId(Long usuarioId) {
        return mapper.entidadeParaDTO(repository.findAllByUsuario_Id(usuarioId), LivrosUsuarioResponseDTO.class);
    }

    public LivrosUsuarioResponseDTO findById(Long id) {
        return mapper.entidadeParaDTO(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado")),
                LivrosUsuarioResponseDTO.class);
    }

    public LivrosUsuarioResponseDTO create(final LivrosUsuarioRequestDTO livroUsuarioDTO) {
        LivrosUsuario livroEntidade = new LivrosUsuario();
        BeanUtils.copyProperties(livroUsuarioDTO, livroEntidade);
        livroEntidade.setDataCriacao(new Date());
        Usuarios usuario = usuarioRepository.findById(livroUsuarioDTO.getUsuarioId()).
                orElseThrow(() -> new ResourceNotFoundException("Não foi possível realizar o cadastro do livro pois não existe usuário cadastrado com id " + livroUsuarioDTO.getUsuarioId()));
        livroEntidade.setUsuario(usuario);

        try {
            return mapper.entidadeParaDTO(repository.save(livroEntidade), LivrosUsuarioResponseDTO.class);
        } catch (Exception e) {
            throw new DatabaseException("Erro ao cadastrar livro na base de dados. " + e.getMessage());
        }
    }

    public LivrosUsuarioResponseDTO update(LivrosUsuarioRequestDTO livroUsuarioDTO, Long id) {
        LivrosUsuario livroEntidade = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há cadastro de livro com id " + id));
        BeanUtils.copyProperties(livroUsuarioDTO, livroEntidade);
        livroEntidade.setId(id);

        try {
            return mapper.entidadeParaDTO(repository.save(livroEntidade), LivrosUsuarioResponseDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
            throw new DatabaseException("Não foi possível atualizar dados do livro. " + e.getMessage());
        }
    }

    public void delete(Long id) {
        LivrosUsuario entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado!"));
        try {
            repository.delete(entity);
        } catch (final DataIntegrityViolationException ex) {
            ex.printStackTrace();
            throw new DatabaseException("Não foi possível realizar a exclusão do livro. " + ex.getMessage());
        }
    }

}
