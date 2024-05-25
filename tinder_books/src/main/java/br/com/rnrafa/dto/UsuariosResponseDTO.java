package br.com.rnrafa.dto;

import br.com.rnrafa.entity.LivrosUsuario;
import br.com.rnrafa.entity.Preferencias;

import java.time.LocalDateTime;
import java.util.List;

public class
UsuariosResponseDTO {
	private Long id;
	private LocalDateTime datacriacao;
	private String nomeCompleto;
	private String email;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private Float latitude;
	private Float longitude;
	private Integer ddd;
	private String telefone;
	private String ativo;
	private String aceiteTermos;
	private Preferencias preferencias;

	private List<LivrosUsuario> livrosList;

	public List<LivrosUsuario> getLivrosList() {
		return livrosList;
	}

	public void setLivrosList(List<LivrosUsuario> livrosList) {
		this.livrosList = livrosList;
	}

	public Preferencias getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(Preferencias preferencias) {
		this.preferencias = preferencias;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}
	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getAceiteTermos() {
		return aceiteTermos;
	}
	public void setAceiteTermos(String aceiteTermos) {
		this.aceiteTermos = aceiteTermos;
	}
	
	
}
