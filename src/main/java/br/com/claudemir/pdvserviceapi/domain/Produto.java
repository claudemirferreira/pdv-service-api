package br.com.claudemir.pdvserviceapi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="PRODUTO_SEQ", sequenceName="PRODUTO_SEQ", allocationSize=1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUTO_SEQ")
	@Column(name = "produto_id")
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(precision = 10, scale = 2)
	private double precoVenda;

	@Column(precision = 10, scale = 2)
	private double precoCompra;
	
	private Integer estoque;
	
	private Integer estoqueMinimo;

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemVenda> itens = new HashSet<>();

	public Produto() {
	}
	
	public Produto(Integer id) {
		this.id = id;
	}

	public Produto(Integer id, String nome, double precoVenda, double precoCompra, Integer estoque, Integer estoqueMinimo) {
		this.id = id;
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.precoCompra = precoCompra;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//    @JsonIgnore
//    public List<Pedido> getPedidos() {
//        List<Pedido> lista = new ArrayList<>();
//        for (ItemPedido item : itens)
//            lista.add(item.getPedido());
//
//        return lista;
//    }

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Integer getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(Integer estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Produto produto = (Produto) o;
		return Objects.equals(id, produto.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
