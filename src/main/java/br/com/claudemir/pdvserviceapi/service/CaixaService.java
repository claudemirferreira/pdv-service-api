package br.com.claudemir.pdvserviceapi.service;

import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Caixa;
import br.com.claudemir.pdvserviceapi.dto.AbrirCaixaDTO;

@Service
public interface CaixaService extends BaseService<Caixa, Integer> {

	public Caixa abrir(AbrirCaixaDTO entity);

	public Caixa pesquisarCaixa(String statusCaixa, Integer usuarioId);

}