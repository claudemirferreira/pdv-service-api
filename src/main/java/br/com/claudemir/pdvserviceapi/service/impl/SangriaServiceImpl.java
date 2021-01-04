package br.com.claudemir.pdvserviceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Sangria;
import br.com.claudemir.pdvserviceapi.repository.SangriaRepository;
import br.com.claudemir.pdvserviceapi.service.SangriaService;

@Service
public class SangriaServiceImpl extends AbstractService<Sangria, Integer> implements SangriaService {

	private SangriaRepository repository;

	@Autowired
	public SangriaServiceImpl(SangriaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Sangria, Integer> getRepository() {
		return repository;
	}

}
