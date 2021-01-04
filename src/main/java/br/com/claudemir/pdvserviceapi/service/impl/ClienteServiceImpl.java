package br.com.claudemir.pdvserviceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Cliente;
import br.com.claudemir.pdvserviceapi.repository.ClienteRepository;
import br.com.claudemir.pdvserviceapi.service.ClienteService;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Integer> implements ClienteService {

	private ClienteRepository repository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Cliente, Integer> getRepository() {
		return repository;
	}

}
