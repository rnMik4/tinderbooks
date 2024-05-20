package br.com.rnrafa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_completo", nullable = false, length = 80)
	private String nomeCompleto;
	
	@Column(name = "email", nullable = false, length = 80)
	private String email;
	
	@Column(name = "cep", nullable = false, length = 80)
	private String cep;
	
	@Column(name = "rua", nullable = false, length = 80)
	private String rua;
	
	@Column(name = "bairro", nullable = false, length = 80)
	private String bairro;
	
	@Column(name = "cidade", nullable = false, length = 80)
	private String cidade;
	
	@Column(name = "uf", nullable = false, length = 80)
	private String uf;
	
	@Column(name = "latitude", nullable = false, length = 80)
	private Float latitude;
	
	@Column(name = "longitude", nullable = false, length = 80)
	private Float longitude;
	
	@Column(name = "data_criacao", nullable = false, length = 80)
	private LocalDateTime datacriacao;
	
	@Column(name = "ddd", nullable = false, length = 80)
	private Integer ddd;
	
	@Column(name = "telefone", nullable = false, length = 80)
	private String telefone;
	
	@Column(name = "ativo", nullable = false, length = 80)
	private String ativo;
	
	@Column(name = "aceite_termos", nullable = false, length = 80)
	private String aceiteTermos;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
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
