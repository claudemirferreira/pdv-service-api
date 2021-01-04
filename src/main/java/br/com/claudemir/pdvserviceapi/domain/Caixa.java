package br.com.claudemir.pdvserviceapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "caixa_id")
	private Integer id;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
	private double saldoInicial;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
	private double totalApurado;

	@Column(precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2)")
	private double totalApuradoSistema;

	@Column(nullable = false, length = 1)
	private String statusCaixa;

	@OneToMany(mappedBy = "caixa")
	private List<Venda> vendas;

	public Caixa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public double getTotalApurado() {
		return totalApurado;
	}

	public void setTotalApurado(double totalApurado) {
		this.totalApurado = totalApurado;
	}

	public double getTotalApuradoSistema() {
		return totalApuradoSistema;
	}

	public void setTotalApuradoSistema(double totalApuradoSistema) {
		this.totalApuradoSistema = totalApuradoSistema;
	}

	public String getStatusCaixa() {
		return statusCaixa;
	}

	public void setStatusCaixa(String statusCaixa) {
		this.statusCaixa = statusCaixa;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Caixa(Integer id, LocalDateTime data, Usuario usuario, double saldoInicial, double totalApurado,
			double totalApuradoSistema, String statusCaixa) {
		this.id = id;
		this.data = data;
		this.usuario = usuario;
		this.saldoInicial = saldoInicial;
		this.totalApurado = totalApurado;
		this.totalApuradoSistema = totalApuradoSistema;
		this.statusCaixa = statusCaixa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Caixa categoria = (Caixa) o;
		return Objects.equals(id, categoria.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
