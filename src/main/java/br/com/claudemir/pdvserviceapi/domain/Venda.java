package br.com.claudemir.pdvserviceapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "venda_id")
	private Integer id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime data;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
	private double total;

	@ManyToOne
	@JoinColumn(name = "caixa_id")
	@JsonIgnore
	private Caixa caixa;

	@OneToMany(mappedBy = "id.venda")
	@JsonIgnore
	private Set<ItemVenda> itens = new HashSet<>();

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}

	public Venda() {
	}
	
	public Venda(Integer id) {
		this.id = id;
	}

	public Venda(Integer id, LocalDateTime data, double total, Caixa caixa) {
		this.id = id;
		this.data = data;
		this.total = total;
		this.caixa = caixa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Venda categoria = (Venda) o;
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
