package br.com.claudemir.pdvserviceapi.dto;

import java.io.Serializable;

public class ItemVendaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private double desconto;

	private Integer quantidade;

	private double preco;

	private ProdutoDTO produto;

	private VendaDTO venda;

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

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public VendaDTO getVenda() {
		return venda;
	}

	public void setVenda(VendaDTO venda) {
		this.venda = venda;
	}

}