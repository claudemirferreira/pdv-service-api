package br.com.claudemir.pdvserviceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Produto;
import br.com.claudemir.pdvserviceapi.dto.PageableDTO;
import br.com.claudemir.pdvserviceapi.repository.ProdutoRepository;
import br.com.claudemir.pdvserviceapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl extends AbstractService<Produto, Integer> implements ProdutoService {

	private ProdutoRepository repository;

	@Autowired
	public ProdutoServiceImpl(ProdutoRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Produto, Integer> getRepository() {
		return repository;
	}

	@Override
	public Page<Produto> findByNomeContaining(PageableDTO dto) {
		Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by("nome"));
		return repository.findByNomeContaining(dto.getNome(), pageable);
	}

}
