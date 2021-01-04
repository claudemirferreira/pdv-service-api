package br.com.claudemir.pdvserviceapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.ItemVenda;
import br.com.claudemir.pdvserviceapi.dto.AtualizarItemVendaDTO;
import br.com.claudemir.pdvserviceapi.repository.ItemVendaRepository;
import br.com.claudemir.pdvserviceapi.service.ItemVendaService;

@Service
public class ItemVendaServiceImpl extends AbstractService<ItemVenda, Integer> implements ItemVendaService {

	private ItemVendaRepository repository;

	@Autowired
	public ItemVendaServiceImpl(ItemVendaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<ItemVenda, Integer> getRepository() {
		return repository;
	}

	@Override
	public List<ItemVenda> incluir(ItemVenda entity) {
		repository.save(entity);
		return pesquisarPorVenda(entity.getVenda().getId());
	}

	@Override
	public List<ItemVenda> excluir(ItemVenda entity) {
		repository.delete(entity);
		return pesquisarPorVenda(entity.getVenda().getId());
	}

	@Override
	public List<ItemVenda> pesquisarPorVenda(Integer vendaId) {
		return repository.pesquisarPorVenda(vendaId);
	}

	@Override
	public List<ItemVenda> update(AtualizarItemVendaDTO dto) {
		ItemVenda entity = AtualizarItemVendaDTO.toEntity(dto);
		repository.save(entity);
		return pesquisarPorVenda(entity.getVenda().getId());
	}

}
