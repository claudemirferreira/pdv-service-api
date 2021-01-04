package br.com.claudemir.pdvserviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.pdvserviceapi.domain.Venda;
import br.com.claudemir.pdvserviceapi.dto.VendaDTO;
import br.com.claudemir.pdvserviceapi.service.BaseService;
import br.com.claudemir.pdvserviceapi.service.VendaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pdv/venda/")
@CrossOrigin(origins = "*")
@Api(value = "API rest venda")
public class VendaController extends AbstractController<Venda, Integer, VendaDTO> {

	@Autowired
	private VendaService service;

	@Override
	protected BaseService<Venda, Integer> getService() {
		return service;
	}

	@Override
	protected Class<VendaDTO> getDtoClass() {
		return VendaDTO.class;
	}

	@Override
	protected Class<Venda> getEntityClass() {
		return Venda.class;
	}
	
}