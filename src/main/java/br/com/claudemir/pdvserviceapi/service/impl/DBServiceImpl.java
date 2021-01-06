package br.com.claudemir.pdvserviceapi.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.claudemir.pdvserviceapi.domain.Caixa;
import br.com.claudemir.pdvserviceapi.domain.ItemVenda;
import br.com.claudemir.pdvserviceapi.domain.Produto;
import br.com.claudemir.pdvserviceapi.domain.Usuario;
import br.com.claudemir.pdvserviceapi.domain.Venda;
import br.com.claudemir.pdvserviceapi.domain.enums.StatusCaixa;
import br.com.claudemir.pdvserviceapi.repository.CaixaRepository;
import br.com.claudemir.pdvserviceapi.repository.ItemVendaRepository;
import br.com.claudemir.pdvserviceapi.repository.ProdutoRepository;
import br.com.claudemir.pdvserviceapi.repository.UsuarioRepository;
import br.com.claudemir.pdvserviceapi.repository.VendaRepository;
import br.com.claudemir.pdvserviceapi.service.DBService;

@Service
public class DBServiceImpl implements DBService {

	@Autowired
	private CaixaRepository caixaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private ItemVendaRepository itemVendaRepository;

	@Override
	public void initDB() {
		Usuario usuario = new Usuario(null, "admin", "admin", "admin@gmail.com");
		usuario = usuarioRepository.save(usuario);
		System.out.println("=======================================" + LocalDateTime.now(ZoneId.of("America/Manaus")));

		Caixa caixa = new Caixa(null, LocalDateTime.now(), usuario, 10.00, 0.00, 0.00, StatusCaixa.ABERTO.getCod());
		caixaRepository.save(caixa);

		Produto p1 = new Produto(null, "Feijão", 10.00, 5.00, 10, 2);
		Produto p2 = new Produto(null, "Arroz", 15.00, 7.00, 10, 2);
		Produto p3 = new Produto(null, "Açucar", 15.00, 7.00, 10, 2);
		Produto p4 = new Produto(null, "Amaciante", 15.00, 7.00, 10, 2);
		Produto p5 = new Produto(null, "Algodão", 15.00, 7.00, 10, 2);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Venda venda = new Venda(null, LocalDateTime.now(ZoneId.of("America/Manaus")), 0.0, caixa);

		ItemVenda i1 = new ItemVenda(venda, p1, 0.0, 2, p1.getPrecoVenda());
		ItemVenda i2 = new ItemVenda(venda, p2, 0.0, 3, p2.getPrecoVenda());

		List<ItemVenda> itens = new ArrayList<ItemVenda>(Arrays.asList(i1, i2));

		for (ItemVenda itemVenda : itens) {
			venda.setTotal(venda.getTotal() + itemVenda.getSubTotal());
		}
		vendaRepository.save(venda);
		itemVendaRepository.saveAll(itens);

	}

}
