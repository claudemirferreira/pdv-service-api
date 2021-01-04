package br.com.claudemir.pdvserviceapi.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VendaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private LocalDateTime data;

	private double total;

	private CaixaDTO caixa;

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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public CaixaDTO getCaixa() {
		return caixa;
	}

	public void setCaixa(CaixaDTO caixa) {
		this.caixa = caixa;
	}

}