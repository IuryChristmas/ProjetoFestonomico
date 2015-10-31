package br.com.festonomico.dao;

import java.util.List;

import br.com.festonomico.modelo.Produto;

public interface ProdutoDao {
	//insere produto
	void insereProduto(Produto produto);
	//lista todos produtos do sistema
	List<Produto> getLista();
	//seleciona produto especifico para edi��o
	List<Produto> getProduto(int id);
	//respons�vel pela edi��o
	void alteraProduto(Produto produto);
	//remove produto
	void removeProduto(Produto produto);
}
