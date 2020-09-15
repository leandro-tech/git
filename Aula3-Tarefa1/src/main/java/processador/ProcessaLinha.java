package processador;

import java.util.ArrayList;
import java.util.List;

import banco.BairroBd;
import banco.CidadeBd;
import banco.EmpresaBd;
import banco.ProdutoBd;
import banco.RamoBd;
import banco.UfBd;
import csv.EmpresaCsv;
import leitor.ProcessadorLinha;
import modelo.Bairro;
import modelo.Cidade;
import modelo.Empresa;
import modelo.Produto;
import modelo.Ramo;
import modelo.Uf;

public class ProcessaLinha implements ProcessadorLinha {

	private EmpresaBd empresaBd = new EmpresaBd();
	private UfBd ufBd = new UfBd();
	private CidadeBd cidadeBd = new CidadeBd();
	private BairroBd bairroBd = new BairroBd();
	private RamoBd ramoBd = new RamoBd();
	private ProdutoBd produtoBd = new ProdutoBd();
	
	@Override
	public void processa(String linha) {
		EmpresaCsv csv = new EmpresaCsv(linha);
		
		Uf uf = ufBd.buscaPelaSigla(csv.getSiglaUf());
		if (uf == null) {
			uf = new Uf();
			uf.setSigla(csv.getSiglaUf());
			ufBd.adicionar(uf);
		}
		
		Cidade cidade = cidadeBd.buscaPelaCidade(csv.getCidade());
		if (cidade == null) {
			cidade = new Cidade();
			cidade.setNome(csv.getCidade());
			cidadeBd.adicionar(cidade);
		}
		
		Bairro bairro = bairroBd.buscaPeloBairro(csv.getBairro());
		if (bairro == null) {
			bairro = new Bairro();
			bairro.setNome(csv.getBairro());
			bairroBd.adicionar(bairro);
		}
		
		Ramo ramo = ramoBd.buscaPeloRamo(csv.getRamo());
		if (ramo == null) {
			ramo = new Ramo();
			ramo.setNome(csv.getRamo());
			ramoBd.adicionar(ramo);
		}
		
		List<String> nomeProdutos = csv.getNomeProdutos();
		List<Produto> produtos = new ArrayList<>();
		for (String nomeProduto : nomeProdutos) {
			Produto produto = produtoBd.buscaPeloProduto(nomeProduto);
			if (produto == null) {
				produto = new Produto();
				produto.setNome(nomeProduto);
				produtoBd.adicionar(produto);
			}
			produtos.add(produto);
		}
				
		Empresa empresa = new Empresa();
		empresa.setRazao(csv.getRazao());
		empresa.setLogadouro(csv.getLogradouro());
		empresa.setContato(csv.getContato());
		empresa.setNumFuncionarios(csv.getNumFuncionarios());
		empresa.setSite(csv.getSite());
		empresa.setEmail(csv.getEmail());
		empresa.setCep(csv.getCep());
		empresa.setTelefone(csv.getTelefone());
		empresa.setFax(csv.getFax());
		//System.out.println(csv.getCidade());
		
		empresa.setUf(uf);
		empresa.setCidade(cidade);
		empresa.setBairro(bairro);
		empresa.setRamo(ramo);
		empresa.setProdutos(produtos);
		
		empresaBd.adicionar(empresa);
	}

}
