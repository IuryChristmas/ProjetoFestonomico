package br.com.festonomico.dao;

import java.util.List;

import br.com.festonomico.modelo.Produto;
/**
 * Classe responsável por prover a assinatura dos métodos de 
 * entradas e saídas de dados da tabela de produtos
 * @author andersonmartins
 *
 */
public interface ProdutoDao {
	//	insere produto
	void insereProduto(Produto produto);
	//	lista todos produtos do sistema
	List<Produto> getLista(String IdSessao);
	//	seleciona produto especifico para edi��o
	List<Produto> getProduto(int id);
	//	respons�vel pela edi��o
	void alteraProduto(Produto produto);
	//	remove produto
	void removeProduto(Produto produto);
	//	procedure
	void callProcedure(String id);
}
