package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.pdvserviceapi.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
