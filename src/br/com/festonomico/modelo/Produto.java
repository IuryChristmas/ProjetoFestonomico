/*
 * @author IuryChristmas
 */
package br.com.festonomico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	private int id;
	private String nome;
	private int quantidade;
	private double preco;
	
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
		
}
