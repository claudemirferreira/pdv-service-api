package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.pdvserviceapi.domain.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
