package br.com.festonomico.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.jdbc.ConnectionFactory;
import br.com.festonomico.modelo.Produto;

/**
 * Classe responsável por prover a implementação dos métodos
 * de comunicação com a tabela produto
 * @author andersonmartins
 *
 */
public class ProdutoDaoImpl implements ProdutoDao {

	Logger LOG = Logger.getLogger(ProdutoDaoImpl.class);
	
	Connection con = null;
	
	public ProdutoDaoImpl(){
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
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
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
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		
		return produtos;
	}
	//seleciona produto especifico para edi��o
	public List<Produto> getProduto(int id){
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			String sql = "select * from produtos where id=?";

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
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return produtos;
	}
	//respons�vel pela edi��o
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
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
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
		}catch(SQLException e){
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
	
	public void callProcedure(String id) {
		//	CALL carregarBase('b2a1c3e5d5');
		String sql = "CALL carregarBase(?)";
		
		try {
			CallableStatement stmt = con.prepareCall(sql);
			
			stmt.setString(1, id);
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}
	
}
