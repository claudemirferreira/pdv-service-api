package br.com.claudemir.pdvserviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.pdvserviceapi.domain.Sangria;
import br.com.claudemir.pdvserviceapi.dto.SangriaDTO;
import br.com.claudemir.pdvserviceapi.service.BaseService;
import br.com.claudemir.pdvserviceapi.service.SangriaService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/pdv/sangria/")
@CrossOrigin(origins = "*")
@Api(value = "API rest sangria")
public class SangriaController extends AbstractController<Sangria, Integer, SangriaDTO> {

	@Autowired
	private SangriaService service;

	@Override
	protected BaseService<Sangria, Integer> getService() {
		return service;
	}

	@Override
	protected Class<SangriaDTO> getDtoClass() {
		return SangriaDTO.class;
	}

	@Override
	protected Class<Sangria> getEntityClass() {
		return Sangria.class;
	}

}