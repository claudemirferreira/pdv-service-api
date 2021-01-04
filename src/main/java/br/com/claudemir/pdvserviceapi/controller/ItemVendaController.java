package br.com.claudemir.pdvserviceapi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.pdvserviceapi.domain.ItemVenda;
import br.com.claudemir.pdvserviceapi.dto.AtualizarItemVendaDTO;
import br.com.claudemir.pdvserviceapi.dto.ItemVendaDTO;
import br.com.claudemir.pdvserviceapi.response.Response;
import br.com.claudemir.pdvserviceapi.service.BaseService;
import br.com.claudemir.pdvserviceapi.service.ItemVendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pdv/item-venda/")
@CrossOrigin(origins = "*")
@Api(value = "API rest item-venda")
public class ItemVendaController extends AbstractController<ItemVenda, Integer, ItemVendaDTO> {

	@Autowired
	private ItemVendaService service;

	@Override
	protected BaseService<ItemVenda, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ItemVendaDTO> getDtoClass() {
		return ItemVendaDTO.class;
	}

	@Override
	protected Class<ItemVenda> getEntityClass() {
		return ItemVenda.class;
	}

	@RequestMapping(value = "venda/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "pegar registro por venda")
	public ResponseEntity<Response<List<ItemVendaDTO>>> pesquisarPorVenda(@PathVariable("id") Integer id) {
		Response<List<ItemVendaDTO>> response = new Response<List<ItemVendaDTO>>();
		try {
			List<ItemVendaDTO> dtos = toDto(service.pesquisarPorVenda(id));
			response.setContent(dtos);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id:" + id);
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "excluir", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "pegar registro por venda")
	public ResponseEntity<Response<List<ItemVendaDTO>>> excluir(HttpServletResponse resp,
			@Valid @RequestBody ItemVendaDTO dto) {
		Response<List<ItemVendaDTO>> response = new Response<List<ItemVendaDTO>>();
		try {
			List<ItemVendaDTO> dtos = toDto(service.excluir(this.toEntity(dto)));
			response.setContent(dtos);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id: " + dto.getProduto().getId());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "atualizar um item da venda")
	public ResponseEntity<Response<List<ItemVendaDTO>>> update(HttpServletResponse resp,
			@Valid @RequestBody AtualizarItemVendaDTO dto) {
		Response<List<ItemVendaDTO>> response = new Response<List<ItemVendaDTO>>();
		try {
			List<ItemVendaDTO> dtos = toDto(service.update(dto));
			response.setContent(dtos);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.getErrors().add("Register not found id: " + dto.getProdutoId());
			return ResponseEntity.badRequest().body(response);
		}
	}

}