package br.com.claudemir.pdvserviceapi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.pdvserviceapi.domain.Caixa;
import br.com.claudemir.pdvserviceapi.dto.AbrirCaixaDTO;
import br.com.claudemir.pdvserviceapi.dto.CaixaDTO;
import br.com.claudemir.pdvserviceapi.response.Response;
import br.com.claudemir.pdvserviceapi.service.BaseService;
import br.com.claudemir.pdvserviceapi.service.CaixaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pdv/caixa/")
@CrossOrigin(origins = "*")
@Api(value = "API rest caixa")
public class CaixaController extends AbstractController<Caixa, Integer, CaixaDTO> {

	@Autowired
	private CaixaService service;

	@Override
	protected BaseService<Caixa, Integer> getService() {
		return service;
	}

	@RequestMapping(value = "abrir-caixa", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "abrir o caixa")
	public ResponseEntity<Response<CaixaDTO>> Abrir(HttpServletResponse resp, @Valid @RequestBody AbrirCaixaDTO obj) {
		Response<CaixaDTO> response = new Response<CaixaDTO>();
		try {
			CaixaDTO dto = toDto(service.abrir(obj));
			response.setContent(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@Override
	protected Class<CaixaDTO> getDtoClass() {
		return CaixaDTO.class;
	}

	@Override
	protected Class<Caixa> getEntityClass() {
		return Caixa.class;
	}

}