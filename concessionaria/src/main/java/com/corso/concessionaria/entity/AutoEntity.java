package com.corso.concessionaria.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="auto")
public class AutoEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "targa")
	private String targa;

	@Column(name = "modello")
	private String modello;
	
	@ManyToOne
	@JoinColumn(name = "cliente", referencedColumnName = "id", nullable = true)
	private ClienteEntity cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, id, modello, targa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoEntity other = (AutoEntity) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(modello, other.modello) && Objects.equals(targa, other.targa);
	}

	@Override
	public String toString() {
		return "AutoEntity [id=" + id + ", targa=" + targa + ", modello=" + modello + ", cliente=" + cliente + "]";
	}

	
}
