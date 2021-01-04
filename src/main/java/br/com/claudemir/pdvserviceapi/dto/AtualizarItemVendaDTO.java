package br.com.claudemir.pdvserviceapi.dto;

import java.io.Serializable;

import br.com.claudemir.pdvserviceapi.domain.ItemVenda;
import br.com.claudemir.pdvserviceapi.domain.Produto;
import br.com.claudemir.pdvserviceapi.domain.Venda;

public class AtualizarItemVendaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private double desconto;

	private Integer quantidade;

	private double preco;

	private Integer produtoId;

	private Integer vendaId;

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getVendaId() {
		return vendaId;
	}

	public void setVendaId(Integer vendaId) {
		this.vendaId = vendaId;
	}
	
	public static ItemVenda toEntity(AtualizarItemVendaDTO dto) {
		ItemVenda entity = new ItemVenda(
				new Venda(dto.getVendaId()), 
				new Produto(dto.getProdutoId()), 
				dto.getDesconto(), 
				dto.getQuantidade(), 
				dto.getPreco());
		return entity;
	}

}