package com.rychlewski.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rychlewski.cursomc.domain.Categoria;
import com.rychlewski.cursomc.domain.Cidade;
import com.rychlewski.cursomc.domain.Cliente;
import com.rychlewski.cursomc.domain.Endereco;
import com.rychlewski.cursomc.domain.Estado;
import com.rychlewski.cursomc.domain.Pagamento;
import com.rychlewski.cursomc.domain.PagamentoComBoleto;
import com.rychlewski.cursomc.domain.PagamentoComCartao;
import com.rychlewski.cursomc.domain.Pedido;
import com.rychlewski.cursomc.domain.Produto;
import com.rychlewski.cursomc.domain.enums.EstadoPagamento;
import com.rychlewski.cursomc.domain.enums.TipoCliente;
import com.rychlewski.cursomc.repositories.CategoriaRepository;
import com.rychlewski.cursomc.repositories.CidadeRepository;
import com.rychlewski.cursomc.repositories.ClienteRepository;
import com.rychlewski.cursomc.repositories.EnderecoRepository;
import com.rychlewski.cursomc.repositories.EstadoRepository;
import com.rychlewski.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));

		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Olimpia", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		
		Cliente cli1 = new Cliente(null, "Marcos Rychlewski", "vinirychlewski@gmail.com", "50317305875", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("22093415", "951438691"));		
		
		Endereco e1 = new Endereco(null, "Rua soldado", "300", "Apto 200", "Jardim", "5673633", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "500", "Sala 200", "Centro", "75443633", cli1, c2);


		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2021 10:32") , cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2021 19:35") , cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2021"), null);
		ped2.setPagamento(pagto2);
		
		
		
		
		
		
	}

}
