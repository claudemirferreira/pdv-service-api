package br.com.claudemir.pdvserviceapi.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public class CaixaDTO {

	private Integer id;

	private LocalTime data;

	private BigDecimal saldoInicial;

	private BigDecimal totalApurado;

	private BigDecimal totalApuradoSistema;

	private String statusCaixa;

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

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public BigDecimal getTotalApurado() {
		return totalApurado;
	}

	public void setTotalApurado(BigDecimal totalApurado) {
		this.totalApurado = totalApurado;
	}

	public BigDecimal getTotalApuradoSistema() {
		return totalApuradoSistema;
	}

	public void setTotalApuradoSistema(BigDecimal totalApuradoSistema) {
		this.totalApuradoSistema = totalApuradoSistema;
	}

	public String getStatusCaixa() {
		return statusCaixa;
	}

	public void setStatusCaixa(String statusCaixa) {
		this.statusCaixa = statusCaixa;
	}

}
