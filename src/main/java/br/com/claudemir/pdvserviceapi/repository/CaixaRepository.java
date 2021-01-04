package br.com.claudemir.pdvserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.claudemir.pdvserviceapi.domain.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Integer> {

	@Query("select u from Caixa u where u.statusCaixa = :statusCaixa and u.usuario.id = :usuarioId")
	public Caixa pesquisarCaixa(@Param("statusCaixa") String statusCaixa, @Param("usuarioId") Integer usuarioId);

}
