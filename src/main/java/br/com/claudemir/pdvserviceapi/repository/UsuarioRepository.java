package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.pdvserviceapi.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
