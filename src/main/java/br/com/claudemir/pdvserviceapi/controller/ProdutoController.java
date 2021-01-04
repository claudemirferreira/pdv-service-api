package br.com.claudemir.pdvserviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.pdvserviceapi.domain.Produto;
import br.com.claudemir.pdvserviceapi.dto.ProdutoDTO;
import br.com.claudemir.pdvserviceapi.service.BaseService;
import br.com.claudemir.pdvserviceapi.service.ProdutoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pdv/produto/")
@CrossOrigin(origins = "*")
@Api(value = "API rest produto")
public class ProdutoController extends AbstractController<Produto, Integer, ProdutoDTO> {

	@Autowired
	private ProdutoService service;

	@Override
	protected BaseService<Produto, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ProdutoDTO> getDtoClass() {
		return ProdutoDTO.class;
	}

	@Override
	protected Class<Produto> getEntityClass() {
		return Produto.class;
	}

}