package br.com.claudemir.pdvserviceapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.ItemVenda;
import br.com.claudemir.pdvserviceapi.dto.AtualizarItemVendaDTO;

@Service
public interface ItemVendaService extends BaseService<ItemVenda, Integer> {

	public List<ItemVenda> incluir(ItemVenda entity);

	public List<ItemVenda> pesquisarPorVenda(Integer vendaId);

	public List<ItemVenda> excluir(ItemVenda entity);

	public List<ItemVenda> update(AtualizarItemVendaDTO dto);

}