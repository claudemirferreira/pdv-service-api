package br.com.claudemir.pdvserviceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.claudemir.pdvserviceapi.domain.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {

	@Query("select u from ItemVenda u where u.id.venda.id = :vendaId")
	public List<ItemVenda> pesquisarPorVenda(@Param("vendaId") Integer vendaId);

}
