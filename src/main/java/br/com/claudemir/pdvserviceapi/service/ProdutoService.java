package br.com.claudemir.pdvserviceapi.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Produto;
import br.com.claudemir.pdvserviceapi.dto.PageableDTO;

@Service
public interface ProdutoService extends BaseService<Produto, Integer> {

	Page<Produto> findByNomeContaining(PageableDTO dto);

}