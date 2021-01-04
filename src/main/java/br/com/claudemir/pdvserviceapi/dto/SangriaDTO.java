package br.com.claudemir.pdvserviceapi.dto;

import java.time.LocalTime;

public class SangriaDTO {

	private Integer id;

	private LocalTime data;

	private double valor;

	private CaixaDTO caixa;

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

	public CaixaDTO getCaixa() {
		return caixa;
	}

	public void setCaixa(CaixaDTO caixa) {
		this.caixa = caixa;
	}

}
