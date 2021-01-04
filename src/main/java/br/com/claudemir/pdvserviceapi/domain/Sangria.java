package br.com.claudemir.pdvserviceapi.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sangria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalTime data;

	@Column(nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
	private double valor;

	@ManyToOne
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;

	public Sangria() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getData() {
		return data;
	}

	public void setData(LocalTime data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Sangria categoria = (Sangria) o;
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
