package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.pdvserviceapi.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
