package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.pdvserviceapi.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Page<Produto> findByNomeContaining(String nome, Pageable pageable);

}
