/*
 * @author IuryChristmas
 */
package br.com.festonomico.modelo;

import java.io.Serializable;

public class Produto implements Serializable {

	private static final long serialVersionUID = -7712673794054932195L;
	
	private int id;
	private String nome;
	private double quantidade;
	private double preco;
	private TipoFesta tipoFesta;
	
	//getters e setters dos atributos
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
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public TipoFesta getTipoFesta() {
		return tipoFesta;
	}
	public void setTipoFesta(TipoFesta tipoFesta) {
		this.tipoFesta = tipoFesta;
	}
		
}
