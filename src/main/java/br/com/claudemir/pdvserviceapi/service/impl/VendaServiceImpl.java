package br.com.claudemir.pdvserviceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Venda;
import br.com.claudemir.pdvserviceapi.repository.VendaRepository;
import br.com.claudemir.pdvserviceapi.service.VendaService;

@Service
public class VendaServiceImpl extends AbstractService<Venda, Integer> implements VendaService {

	private VendaRepository repository;

	@Autowired
	public VendaServiceImpl(VendaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Venda, Integer> getRepository() {
		return repository;
	}

}
