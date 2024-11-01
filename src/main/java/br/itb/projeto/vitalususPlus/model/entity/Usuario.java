package br.itb.projeto.vitalususPlus.model.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome", nullable = false)
	@NotBlank(message = "campo não preenchido")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "nome deve inicial com letras maiúsculas")
	private String nome;

	@Email(message ="campo inválido")
	@NotBlank(message = "campo não preenchido")
	@Column(name="email", nullable = false)
	private String email;

	@NotBlank(message = "campo não preenchido")
	@Column(name="senha", nullable = false)
	private String senha;
	
	@Column(name="nivel_acesso", nullable = false)
	private String nivelAcesso;

	private byte[] foto;
	
	@Column(name="data_cadastro", nullable = false)
	private LocalDateTime dataCadastro;

	@Column(name="status_usuario", nullable = false)
	private String statusUsuario;

	@Column(name="tipo_usuario", nullable = false)
	private String tipoUsuario;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID chaveSeguranca;

	@Column(name="nivel_privacidade", nullable = false)
	private String nivelPrivacidade;

	@Column(name="data_nasc",nullable = false)
	private Date dataNasc;

	@Column(nullable = false)
	private int idade;
	
	public Usuario() {
        this.chaveSeguranca = UUID.randomUUID();
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public UUID getChaveSeguranca() {
		return chaveSeguranca;
	}

	public void setChaveSeguranca(UUID chaveSeguranca) {
		this.chaveSeguranca = chaveSeguranca;
	}

	public String getNivelPrivacidade() {
		return nivelPrivacidade;
	}

	public void setNivelPrivacidade(String nivelPrivacidade) {
		this.nivelPrivacidade = nivelPrivacidade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}

