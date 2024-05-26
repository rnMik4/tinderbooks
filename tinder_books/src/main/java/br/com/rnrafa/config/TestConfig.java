package br.com.rnrafa.config;

import br.com.rnrafa.entity.Denuncias;
import br.com.rnrafa.entity.LivrosUsuario;
import br.com.rnrafa.entity.MotivosDenuncias;
import br.com.rnrafa.entity.Usuarios;
import br.com.rnrafa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivrosUsuarioRepository livrosRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private MotivosDenunciasRepository motivosDenunciasRepository;

    @Autowired
    private DenunciasRepository denunciasRepository;

    @Override
    public void run(String... args) throws Exception {

        final Usuarios usuario1 = new Usuarios();
        usuario1.setEmail("oliver@gmail.com");
        usuario1.setNomeCompleto("Oliver Queen");
        usuario1.setCep("12345-678");
        usuario1.setRua("Rua A");
        usuario1.setBairro("Bairro A");
        usuario1.setCidade("Cidade A");
        usuario1.setUf("UF");
        usuario1.setLatitude(-23.550520f);
        usuario1.setLongitude(-46.633308f);
        usuario1.setDdd(11);
        usuario1.setTelefone("987654321");
        usuario1.setAtivo("S");
        usuario1.setAceiteTermos("true");
        usuario1.setSenha("senha1");
        usuario1.setDatacriacao(LocalDateTime.now());

        final Usuarios usuario2 = new Usuarios();
        usuario2.setEmail("iris@outlook.com");
        usuario2.setNomeCompleto("Iris West Allen");
        usuario2.setCep("23456-789");
        usuario2.setRua("Rua B");
        usuario2.setBairro("Bairro B");
        usuario2.setCidade("Cidade B");
        usuario2.setUf("UF");
        usuario2.setLatitude(-22.906847f);
        usuario2.setLongitude(-43.172896f);
        usuario2.setDdd(21);
        usuario2.setTelefone("912345678");
        usuario2.setAtivo("S");
        usuario2.setAceiteTermos("true");
        usuario2.setSenha("senha2");
        usuario2.setDatacriacao(LocalDateTime.now());

        final Usuarios usuario3 = new Usuarios();
        usuario3.setEmail("barry@gmail.com");
        usuario3.setNomeCompleto("Barry Allen");
        usuario3.setCep("34567-890");
        usuario3.setRua("Rua C");
        usuario3.setBairro("Bairro C");
        usuario3.setCidade("Cidade C");
        usuario3.setUf("UF");
        usuario3.setLatitude(-30.034647f);
        usuario3.setLongitude(-51.217658f);
        usuario3.setDdd(51);
        usuario3.setTelefone("998765432");
        usuario3.setAtivo("S");
        usuario3.setAceiteTermos("true");
        usuario3.setSenha("senha3");
        usuario3.setDatacriacao(LocalDateTime.now());

        final Usuarios usuario4 = new Usuarios();
        usuario4.setEmail("bruce@outlook.com");
        usuario4.setNomeCompleto("Bruce Wayne");
        usuario4.setCep("45678-901");
        usuario4.setRua("Rua D");
        usuario4.setBairro("Bairro D");
        usuario4.setCidade("Cidade D");
        usuario4.setUf("UF");
        usuario4.setLatitude(-19.924502f);
        usuario4.setLongitude(-43.935238f);
        usuario4.setDdd(31);
        usuario4.setTelefone("921234567");
        usuario4.setAtivo("S");
        usuario4.setAceiteTermos("true");
        usuario4.setSenha("senha4");
        usuario4.setDatacriacao(LocalDateTime.now());

        final Usuarios usuario5 = new Usuarios();
        usuario5.setEmail("kara@example.com");
        usuario5.setNomeCompleto("Kara Danvers");
        usuario5.setCep("56789-012");
        usuario5.setRua("Rua E");
        usuario5.setBairro("Bairro E");
        usuario5.setCidade("Cidade E");
        usuario5.setUf("UF");
        usuario5.setLatitude(-15.780148f);
        usuario5.setLongitude(-47.929169f);
        usuario5.setDdd(61);
        usuario5.setTelefone("932345678");
        usuario5.setAtivo("S");
        usuario5.setAceiteTermos("true");
        usuario5.setSenha("senha5");
        usuario5.setDatacriacao(LocalDateTime.now());

        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5));

        final LivrosUsuario livro1 = new LivrosUsuario();
        livro1.setDataCriacao(new Date());
        livro1.setNomeLivro("O senhor dos anéis");
        livro1.setQuantidadePaginas(200);
        livro1.setAutor("Autor A");
        livro1.setAtivo(true);
        livro1.setDescricaoUsuario("Livro disponível para troca.");
        livro1.setUsuario(usuario1);

        final LivrosUsuario livro2 = new LivrosUsuario();
        livro2.setDataCriacao(new Date());
        livro2.setNomeLivro("As Crônicas de Nárnia");
        livro2.setQuantidadePaginas(350);
        livro2.setAutor("Autor B");
        livro2.setAtivo(true);
        livro2.setDescricaoUsuario("Livro disponível para troca.");
        livro2.setUsuario(usuario1);

        final LivrosUsuario livro3 = new LivrosUsuario();
        livro3.setDataCriacao(new Date());
        livro3.setNomeLivro("A Fuga das Galinhas");
        livro3.setQuantidadePaginas(150);
        livro3.setAutor("Autor C");
        livro3.setAtivo(true);
        livro3.setDescricaoUsuario("Livro disponível para troca.");
        livro3.setUsuario(usuario2);

        final LivrosUsuario livro4 = new LivrosUsuario();
        livro4.setDataCriacao(new Date());
        livro4.setNomeLivro("A Revolução dos Bichos");
        livro4.setQuantidadePaginas(450);
        livro4.setAutor("Autor D");
        livro4.setAtivo(true);
        livro4.setDescricaoUsuario("Livro disponível para troca.");
        livro4.setUsuario(usuario2);

        final LivrosUsuario livro5 = new LivrosUsuario();
        livro5.setDataCriacao(new Date());
        livro5.setNomeLivro("Jogos Vorazes I");
        livro5.setQuantidadePaginas(380);
        livro5.setAutor("Autor D");
        livro5.setAtivo(true);
        livro5.setDescricaoUsuario("Livro disponível para troca.");
        livro5.setUsuario(usuario3);

        final LivrosUsuario livro6 = new LivrosUsuario();
        livro6.setDataCriacao(new Date());
        livro6.setNomeLivro("Lógica de Programação Básica com Java");
        livro6.setQuantidadePaginas(475);
        livro6.setAutor("Autor E");
        livro6.setAtivo(true);
        livro6.setDescricaoUsuario("Livro disponível para troca.");
        livro6.setUsuario(usuario3);

        final LivrosUsuario livro7 = new LivrosUsuario();
        livro7.setDataCriacao(new Date());
        livro7.setNomeLivro("Jogos Vorazes II");
        livro7.setQuantidadePaginas(330);
        livro7.setAutor("Autor F");
        livro7.setAtivo(true);
        livro7.setDescricaoUsuario("Livro disponível para troca.");
        livro7.setUsuario(usuario4);

        final LivrosUsuario livro8 = new LivrosUsuario();
        livro8.setDataCriacao(new Date());
        livro8.setNomeLivro("Jogos Vorazes III");
        livro8.setQuantidadePaginas(220);
        livro8.setAutor("Autor F");
        livro8.setAtivo(true);
        livro8.setDescricaoUsuario("Livro disponível para troca.");
        livro8.setUsuario(usuario4);

        final LivrosUsuario livro9 = new LivrosUsuario();
        livro9.setDataCriacao(new Date());
        livro9.setNomeLivro("Ensaio sobre a Cegueira");
        livro9.setQuantidadePaginas(275);
        livro9.setAutor("Autor G");
        livro9.setAtivo(true);
        livro9.setDescricaoUsuario("Livro disponível para troca.");
        livro9.setUsuario(usuario5);

        final LivrosUsuario livro10 = new LivrosUsuario();
        livro10.setDataCriacao(new Date());
        livro10.setNomeLivro("Morte em Veneza");
        livro10.setQuantidadePaginas(410);
        livro10.setAutor("Autor H");
        livro10.setAtivo(true);
        livro10.setDescricaoUsuario("Livro disponível para troca.");
        livro10.setUsuario(usuario5);

        livrosRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9, livro10));


        final MotivosDenuncias motivoDenuncia1 = new MotivosDenuncias();
        motivoDenuncia1.setDataCriacao(new Date());
        motivoDenuncia1.setDescricaoMotivoDenuncia("Mensagens Ofensivas");

        final MotivosDenuncias motivoDenuncia2 = new MotivosDenuncias();
        motivoDenuncia2.setDataCriacao(new Date());
        motivoDenuncia2.setDescricaoMotivoDenuncia("Tentativa de Assédio Virtual");

        motivosDenunciasRepository.saveAll(Arrays.asList(motivoDenuncia1, motivoDenuncia2));


        final Denuncias denuncia1 = new Denuncias();
        denuncia1.setDataCriacao(new Date());
        denuncia1.setDescricaoDenuncia("Recebi mensagens inaproriadas da usuário Iris West, a mesma faltou com respeito comigo de forma muito grossa.");
        denuncia1.setUsuarioDenuncianteId(usuario1.getId());
        denuncia1.setUsuarioDenunciadoId(usuario2.getId());
        denuncia1.setMotivoDenuncia(motivoDenuncia1);

        final Denuncias denuncia2 = new Denuncias();
        denuncia2.setDataCriacao(new Date());
        denuncia2.setDescricaoDenuncia("O usuário Bruce Wayne não está interessado em realizar troca de livro e sim conseguir paqueras.");
        denuncia2.setUsuarioDenuncianteId(usuario5.getId());
        denuncia2.setUsuarioDenunciadoId(usuario4.getId());
        denuncia2.setMotivoDenuncia(motivoDenuncia2);

        denunciasRepository.saveAll(Arrays.asList(denuncia1, denuncia2));

    }
}
