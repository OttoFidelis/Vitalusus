package br.itb.projeto.vitalususPlus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Canal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Canal{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visualizacoes", nullable = false)
	private long visualizacoes;

	@NotBlank(message = "campo não preenchido")
	@Column(name = "nome", nullable = false)
	private String nome;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToMany
	@JoinTable(name="Aluno_segue_canal", joinColumns=
			{@JoinColumn(name="canal_id", nullable = false)}, inverseJoinColumns=
			{@JoinColumn(name="seguidor_id", nullable = false)})
	private List<Aluno> alunos;
	@Column(nullable = false)
	private Integer seguidores;
	
	@ManyToOne
	@JoinColumn(name = "treinador_id",nullable=false)
	private Treinador treinador;

	@JsonIgnore
	@OneToMany(mappedBy = "canal", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Videoaula> videoaulas;

	@Column(length = 999999)
	private String bio;

	@Column(name="numero_videos",nullable = false)
	private int numeroVideos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Integer getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(Integer seguidores) {
		this.seguidores = seguidores;
	}

	public Treinador getTreinador() {
		return treinador;
	}

	public void setTreinador(Treinador treinador) {
		this.treinador = treinador;
	}

	public List<Videoaula> getVideoaulas() {
		return videoaulas;
	}

	public void setVideoaulas(List<Videoaula> videoaulas) {
		this.videoaulas = videoaulas;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public int getNumeroVideos() {
		return numeroVideos;
	}

	public void setNumeroVideos(int numeroVideos) {
		this.numeroVideos = numeroVideos;
	}
}
