package com.corso.concessionaria.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;
	
	@OneToMany(mappedBy = "cliente")
	private List<AutoEntity> autos;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<AutoEntity> getAutos() {
		return autos;
	}

	public void setAutos(List<AutoEntity> autos) {
		this.autos = autos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autos, cognome, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(autos, other.autos) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", autos=" + autos + "]";
	}

	
}
