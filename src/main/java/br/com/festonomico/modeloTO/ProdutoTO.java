package br.com.festonomico.modeloTO;

import java.beans.Transient;
import java.io.Serializable;

import br.com.festonomico.modelo.TipoFesta;

public class ProdutoTO implements Serializable {

	private static transient final long serialVersionUID = -8679998729979874668L;
	
	private int id;
	private String nome;
	private String quantidade;
	private String preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public TipoFesta getTipoFesta() {
		return tipoFesta;
	}
	public void setTipoFesta(TipoFesta tipoFesta) {
		this.tipoFesta = tipoFesta;
	}
	private TipoFesta tipoFesta;
}
