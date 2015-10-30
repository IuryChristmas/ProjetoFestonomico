package br.com.festonomico.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Produto;

public class ProdutoDAO {
	Connection con = null;
	
	public ProdutoDAO(){
		con = new ConnectionFactory().getConnection();
	}
	//insere produto
	public void insereProduto(Produto produto){
		String sql = "insert into produtos"
				+ " (nome,quantidade,preco)"
				+ " values (?,?,?)";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	//lista todos produtos do sistema
	public List<Produto> getLista(){
		String sql = "select *from produtos";
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
						
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				
				produtos.add(produto);
			
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
		return produtos;
	}
	//seleciona produto especifico para edição
	public List<Produto> getProduto(int id){
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			String sql = "select *from produtos where id=?";

			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				
				produtos.add(produto);		
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return produtos;
	}
	//responsável pela edição
	public void alteraProduto(Produto produto){
		String sql = "update produtos set nome=?, quantidade=?, preco=? "
				+ "where id=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setInt(2, produto.getQuantidade());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	}
	//remove produto
	public void removeProduto(Produto produto){
		String sql = "delete from produtos where id=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, produto.getId());
			
			stmt.execute();
			stmt.close();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	}
}
