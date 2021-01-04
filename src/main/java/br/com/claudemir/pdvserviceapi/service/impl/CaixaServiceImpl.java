package br.com.claudemir.pdvserviceapi.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Caixa;
import br.com.claudemir.pdvserviceapi.domain.Usuario;
import br.com.claudemir.pdvserviceapi.domain.enums.StatusCaixa;
import br.com.claudemir.pdvserviceapi.dto.AbrirCaixaDTO;
import br.com.claudemir.pdvserviceapi.repository.CaixaRepository;
import br.com.claudemir.pdvserviceapi.repository.UsuarioRepository;
import br.com.claudemir.pdvserviceapi.service.CaixaService;
import br.com.claudemir.pdvserviceapi.service.exceptions.ExisteCaixaAbertoException;

@Service
public class CaixaServiceImpl extends AbstractService<Caixa, Integer> implements CaixaService {

	private CaixaRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	public CaixaServiceImpl(CaixaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Caixa, Integer> getRepository() {
		return repository;
	}

	@Override
	public Caixa abrir(AbrirCaixaDTO dto) {
		// verifica se existe algum caixa aberto para o usuario
		Caixa caixa = repository.pesquisarCaixa(dto.getStatusCaixa(), dto.getUsuarioId());
		Usuario usuario = usuarioRepository.getOne(dto.getUsuarioId());
		if (caixa == null) {
			caixa = new Caixa(null, LocalDateTime.now(ZoneId.of("America/Manaus")), usuario,
					dto.getSaldoInicial(), 0.00, 0.00, StatusCaixa.ABERTO.getCod());
			repository.save(caixa);
			return caixa;
		} else {
			System.out.println("Já existe uma caixa aberto!");
			throw new ExisteCaixaAbertoException("Já existe uma caixa aberto!");
		}
	}

	@Override
	public Caixa pesquisarCaixa(String statusCaixa, Integer usuarioId) {
		return repository.pesquisarCaixa(statusCaixa, usuarioId);
	}

}
